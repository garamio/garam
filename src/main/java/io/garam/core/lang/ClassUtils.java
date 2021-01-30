package io.garam.core.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public final class ClassUtils {

    public static <T> T instantiate(Class<T> type, ParameterMap parameterMap) {
        try {
            final Constructor<?> constructor = getNoArgConstructor(type);
            final T obj = type.cast(constructor.newInstance());
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                final String raw = parameterMap.getParameter(field.getName());
                if (raw == null) {
                    continue;
                }
                field.set(obj, convertStringValue(raw, field.getType()));
            }
            return obj;
        } catch (java.lang.InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InstantiationException("Unable to set fields.", e);
        }
    }

    private static <T> Constructor<?> getNoArgConstructor(Class<T> type) {
        return Arrays.stream(type.getConstructors())
                .filter(x -> x.getParameterTypes().length == 0)
                .findFirst()
                .orElseThrow(() -> new InstantiationException("Unable to find no-arg constructor."));
    }

    private static Object convertStringValue(String value, Class<?> clazz) {
        if (clazz == String.class) {
            return clazz.cast(value);
        } else if (clazz == int.class || clazz == Integer.class) {
            return Integer.valueOf(value);
        } else if (clazz == long.class || clazz == Long.class) {
            return Long.valueOf(value);
        } else if (clazz == float.class || clazz == Float.class) {
            return Float.valueOf(value);
        } else if (clazz == double.class || clazz == Double.class) {
            return Double.valueOf(value);
        }
        throw new IllegalArgumentException("Unsupported type: " + clazz.getTypeName());
    }

    public static class ParameterMap {
        private final Map<String, String> map;

        private ParameterMap(Map<String, String> map) {
            this.map = map;
        }

        public static ParameterMap of(Map<String, String> map) {
            return new ParameterMap(map);
        }

        public String getParameter(String key) {
            return map.get(key);
        }
    }

}
