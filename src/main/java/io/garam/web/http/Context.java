package io.garam.web.http;

/**
 * Web Context for application.
 *
 * @author hyeyoom
 */
public interface Context {

    Request request();
    Response response();
}
