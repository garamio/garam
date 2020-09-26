package io.garam.core.handlers;

import io.garam.core.http.Context;

/**
 * @author hyeyoom
 */
public interface Middleware {

    /**
     * @param context context for request, response and application
     */
    void execute(Context context);
}
