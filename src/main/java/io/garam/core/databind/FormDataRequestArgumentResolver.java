package io.garam.core.databind;

import io.garam.core.databind.exception.DataBindingException;
import io.garam.core.http.Request;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class FormDataRequestArgumentResolver implements RequestArgumentResolver {

    @Override
    public boolean supports(Request request) {
        return request.getContentType().contains("application/x-www-form-urlencoded");
    }

    @Override
    public <T> T resolveArgument(Request request, Class<T> type) {
        final Constructor<?> constructor = Arrays.stream(type.getConstructors())
                .filter(x -> x.getParameterTypes().length == 0)
                .findFirst()
                .orElseThrow(() -> new DataBindingException("Unable to find non-args constructor."));
        try {
            final T obj = type.cast(constructor.newInstance());
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(obj, request.getParameter(field.getName()));
            }
            return obj;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new DataBindingException("An error occurred during binding");
        }
    }
}
