package io.garam.core.http;

/**
 * Interface to be implemented by objects that represent request from client over http.
 *
 * @author hyeyoom
 */
public interface Request {

    /**
     * @param name field name
     * @return field value
     */
    String getHeader(String name);

    /**
     * @return URI
     */
    String uri();

    /**
     * @param name name of parameter
     * @return value of parameter
     */
    String parameter(String name);

    /**
     * @param type type of object to be bound
     * @param <T> type of data
     */
    <T> T bind(Class<T> type);
}
