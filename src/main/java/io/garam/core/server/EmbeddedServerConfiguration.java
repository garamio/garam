package io.garam.core.server;

import io.garam.core.HandlerMapping;
import io.garam.core.Middlewares;
import io.garam.core.ui.TemplateEngine;

public final class EmbeddedServerConfiguration {

    private final int port;
    private final HandlerMapping handlerMapping;
    private final Middlewares middlewares;
    private final TemplateEngine templateEngine;

    public EmbeddedServerConfiguration(int port, HandlerMapping handlerMapping, Middlewares middlewares, TemplateEngine templateEngine) {
        this.port = port;
        this.handlerMapping = handlerMapping;
        this.middlewares = middlewares;
        this.templateEngine = templateEngine;
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

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}
