package io.garam.core.environment;

/**
 * Interface to be implemented by objects that resolve properties.
 *
 * @author hyeyoom
 */
public interface PropertyResolver {

    /**
     * @param key key to find value
     * @return corresponding value. nullable.
     */
    String getProperty(String key);

    /**
     * @param key          key to find value
     * @param defaultValue if key not exist, defaultValue will be returned.
     * @return corresponding value.
     */
    String getProperty(String key, String defaultValue);

}
