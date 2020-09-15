package io.garam.web.server;

import io.garam.web.HandlerMapping;

public final class EmbeddedServerConfiguration {

    private final int port;
    private final HandlerMapping handlerMapping;

    public EmbeddedServerConfiguration(int port, HandlerMapping handlerMapping) {
        this.port = port;
        this.handlerMapping = handlerMapping;
    }

    public int getPort() {
        return port;
    }

    public HandlerMapping getHandlerMapping() {
        return handlerMapping;
    }
}
