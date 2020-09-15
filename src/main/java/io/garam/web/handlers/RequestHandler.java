package io.garam.web.handlers;

import io.garam.web.http.Context;

/**
 * @author hyeyoom
 */
@FunctionalInterface
public interface RequestHandler {

    /**
     * @param context context for request, response and application
     */
    void handle(Context context);
}
