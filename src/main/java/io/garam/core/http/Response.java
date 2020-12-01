package io.garam.core.http;

/**
 * Interface to be implemented by objects that represent response to client through http.
 *
 * @author hyeyoom
 */
public interface Response {

    /**
     * @param status status to set for response
     * @return response itself
     */
    Response status(HttpStatus status);

    /**
     * @param contentType type that specifies the MIME type of the content
     * @return response itself
     */
    Response contentType(String contentType);

    /**
     * @param body message body
     * @return response itself
     */
    Response text(String body);

    /**
     * @param path path to move
     * @return response itself
     */
    Response redirect(String path);

    /**
     * @param name name of header
     * @param value value of header
     * @return response itself
     */
    Response header(String name, String value);
}
