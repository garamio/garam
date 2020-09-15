package io.garam.core;

/**
 * Interface to be implemented by objects that hold instances.
 *
 * @author hyeyoom
 */
public interface GaramFactory {

    /**
     * @param name     alias for instance to be managed by framework
     * @param instance actual instance. Managed by framework
     */
    void registerGaram(String name, Object instance);

    /**
     * @param name         alias for instance to be managed by framework
     * @param requiredType type of instance
     * @param <T>          parameterized type of instance
     * @return instance
     */
    <T> T getGaram(String name, Class<T> requiredType);
}
