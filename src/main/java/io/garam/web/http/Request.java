package io.garam.web.http;

/**
 * Interface to be implemented by objects that represent request from client over http.
 *
 * @author hyeyoom
 */
public interface Request {

    String uri();

    String parameter(String name);

}
