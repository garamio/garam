package io.garam.core.databind;

import io.garam.core.databind.exception.DataBindingException;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class QueryStringRequestArgumentResolver implements RequestArgumentResolver {

    @Override
    public boolean supports(HttpServletRequest request) {
        return request.getQueryString() != null;
    }

    @Override
    public <T> T getBoundData(HttpServletRequest request, Class<T> type) {
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
