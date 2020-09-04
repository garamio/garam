package io.garam.core;

/**
 * Interface to be implemented by objects that hold instances.
 */
public interface GaramFactory {

    /**
     *
     * @param name name of instance.
     * @return instance
     */
    Object getGaram(String name);
}
