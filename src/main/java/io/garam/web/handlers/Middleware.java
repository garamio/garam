package io.garam.web.handlers;

import io.garam.web.http.Context;

/**
 * @author hyeyoom
 */
public interface Middleware {

    /**
     * @param context context for request, response and application
     */
    void execute(Context context);
}
