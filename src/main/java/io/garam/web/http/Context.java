package io.garam.web.http;

import io.garam.web.ui.Model;

/**
 * Interface to be implemented by objects that represent the context of the current HTTP request.
 * It also holds request, response and application context.
 *
 * @author hyeyoom
 */
public interface Context {

    /**
     * @return request
     */
    Request request();

    /**
     * @return response
     */
    Response response();

    /**
     * @return session
     */
    Session session();

    void render(String templateName, Model model);

}
