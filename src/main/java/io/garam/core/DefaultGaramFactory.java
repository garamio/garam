package io.garam.core;

import java.util.HashMap;
import java.util.Map;

public class DefaultGaramFactory implements GaramFactory {

    private final Map<String, Object> namedGaramFactory = new HashMap<>();

    @Override
    public void registerGaram(String name, Object instance) {
        namedGaramFactory.put(name, instance);
    }

    @Override
    public <T> T getGaram(String name, Class<T> requiredType) {
        return requiredType.cast(namedGaramFactory.get(name));
    }
}
