package io.garam.core.handlers;

import io.garam.core.http.Context;

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
