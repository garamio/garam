package io.garam.core;

import io.garam.core.handlers.Middleware;
import io.garam.core.handlers.RequestHandler;
import io.garam.core.http.RequestMethod;
import io.garam.core.server.DefaultEmbeddedServerFactory;
import io.garam.core.server.EmbeddedServer;
import io.garam.core.server.EmbeddedServerConfiguration;
import io.garam.core.server.EmbeddedServerFactory;
import io.garam.core.ui.MustacheTemplateEngine;
import io.garam.core.ui.TemplateEngine;

import java.util.*;

/**
 * Garam Web Application Instance
 *
 * @author hyeyoom
 */
final class GaramFlow {

    private static final int UNDEFINED_PORT = -1;

    private int port = UNDEFINED_PORT;

    private final EmbeddedServer embeddedServer;
    private final Map<HandlerKey, HandlerExecutor> handlerMap = new HashMap<>();
    private final List<Middleware> aroundMiddlewares = new ArrayList<>();
    private final List<Middleware> beforeMiddlewares = new ArrayList<>();
    private final List<Middleware> afterMiddlewares = new ArrayList<>();
    private TemplateEngine templateEngine = new MustacheTemplateEngine();

    private GaramFlow() {
        EmbeddedServerFactory embeddedServerFactory = new DefaultEmbeddedServerFactory();
        embeddedServer = embeddedServerFactory.getEmbeddedServer(EmbeddedServerFactory.Type.JETTY);
    }

    static GaramFlow getDefault() {
        return new GaramFlow();
    }

    void addHandler(String path, RequestHandler handler, RequestMethod method) {
        final HandlerKey handlerKey = new HandlerKey(path, method);
        final HandlerExecutor handlerExecutor = new HandlerExecutor(handler);
        handlerMap.put(handlerKey, handlerExecutor);
    }

    void port(int port) {
        if (this.port == UNDEFINED_PORT) {
            this.port = port;
        }
    }

    /**
     * start web application instance
     */
    void flow() throws Exception {
        try {
            final HandlerMapping handlerMapping = new HandlerMapping(handlerMap);
            final Middlewares middlewares = new Middlewares(aroundMiddlewares, beforeMiddlewares, afterMiddlewares);
            final EmbeddedServerConfiguration configuration = new EmbeddedServerConfiguration(port, handlerMapping, middlewares, templateEngine);
            embeddedServer.init(configuration);
            embeddedServer.startServer();
        } catch (Exception e) {
            embeddedServer.abort();
        }
    }

    public void use(Middleware... middlewares) {
        this.aroundMiddlewares.addAll(Arrays.asList(middlewares));
    }

    public void before(Middleware... middlewares) {
        this.beforeMiddlewares.addAll(Arrays.asList(middlewares));
    }

    public void after(Middleware... middlewares) {
        this.afterMiddlewares.addAll(Arrays.asList(middlewares));
    }

    public void registerTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
}
