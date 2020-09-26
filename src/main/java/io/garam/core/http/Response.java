package io.garam.core.http;

/**
 * Interface to be implemented by objects that represent response to client through http.
 *
 * @author hyeyoom
 */
public interface Response {

    Response status(HttpStatus status);

    Response contentType(String contentType);

    Response text(String body);

}
