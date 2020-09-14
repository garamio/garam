package io.garam.web.http;

/**
 * Web Context for application.
 *
 * @author hyeyoom
 */
public interface Context {

    Request getRequest();

    Response getResponse();
}
