package io.garam.web.server;

import io.garam.web.HandlerMapping;
import io.garam.web.Middlewares;

public final class EmbeddedServerConfiguration {

    private final int port;
    private final HandlerMapping handlerMapping;
    private final Middlewares middlewares;

    public EmbeddedServerConfiguration(int port, HandlerMapping handlerMapping, Middlewares middlewares) {
        this.port = port;
        this.handlerMapping = handlerMapping;
        this.middlewares = middlewares;
    }

    public int getPort() {
        return port;
    }

    public HandlerMapping getHandlerMapping() {
        return handlerMapping;
    }

    public Middlewares getMiddlewares() {
        return middlewares;
    }
}
