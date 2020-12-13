package io.garam.core;

import io.garam.core.handlers.Middleware;
import io.garam.core.http.Context;

import java.util.List;

/**
 * First class collection for middlewares. This object holds actual middlewares.
 *
 * @author hyeyoom
 */
public class Middlewares {

    private final List<Middleware> aroundMiddlewares;
    private final List<Middleware> beforeMiddlewares;
    private final List<Middleware> afterMiddlewares;

    public Middlewares(List<Middleware> aroundMiddlewares, List<Middleware> beforeMiddlewares, List<Middleware> afterMiddlewares) {
        this.aroundMiddlewares = aroundMiddlewares;
        this.beforeMiddlewares = beforeMiddlewares;
        this.afterMiddlewares = afterMiddlewares;
    }

    public void executeAround(Context ctx) {
        aroundMiddlewares.forEach(middleware -> middleware.execute(ctx));
    }

    public void executeBefore(Context ctx) {
        beforeMiddlewares.forEach(middleware -> middleware.execute(ctx));
    }

    public void executeAfter(Context ctx) {
        afterMiddlewares.forEach(middleware -> middleware.execute(ctx));
    }
}
