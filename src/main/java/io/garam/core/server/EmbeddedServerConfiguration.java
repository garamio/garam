package io.garam.core.server;

import io.garam.core.HandlerMapping;
import io.garam.core.Middlewares;

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
