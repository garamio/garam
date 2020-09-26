package io.garam.core;

import io.garam.core.handlers.Middleware;

import java.util.List;

public class Middlewares {

    private final List<Middleware> aroundMiddlewares;
    private final List<Middleware> beforeMiddlewares;
    private final List<Middleware> afterMiddlewares;

    public Middlewares(List<Middleware> aroundMiddlewares, List<Middleware> beforeMiddlewares, List<Middleware> afterMiddlewares) {
        this.aroundMiddlewares = aroundMiddlewares;
        this.beforeMiddlewares = beforeMiddlewares;
        this.afterMiddlewares = afterMiddlewares;
    }

    public List<Middleware> getAroundMiddlewares() {
        return aroundMiddlewares;
    }

    public List<Middleware> getBeforeMiddlewares() {
        return beforeMiddlewares;
    }

    public List<Middleware> getAfterMiddlewares() {
        return afterMiddlewares;
    }
}
