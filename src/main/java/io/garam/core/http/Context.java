package io.garam.core.http;

import io.garam.core.ui.Model;

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

    /**
     * @return model
     */
    Model model();

    /**
     * @param viewName the name of view.
     * @param model the holder for model attributes.
     */
    void render(String viewName, Model model);

}
