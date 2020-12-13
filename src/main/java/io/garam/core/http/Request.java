package io.garam.core.http;

/**
 * Interface to be implemented by objects that represent request from client over http.
 *
 * @author hyeyoom
 */
public interface Request extends HttpMessage {

    /**
     * @return URI
     */
    String uri();

    /**
     * @param name name of parameter
     * @return value of parameter
     */
    String parameter(String name);

}
