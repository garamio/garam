package io.garam.web;

import io.garam.core.DefaultGaramFactory;
import io.garam.core.GaramFactory;
import io.garam.web.handlers.RequestHandler;
import io.garam.web.http.RequestMethod;
import io.garam.web.server.DefaultEmbeddedServerFactory;
import io.garam.web.server.EmbeddedServer;
import io.garam.web.server.EmbeddedServerFactory;

/**
 * Garam Web Application Instance
 *
 * @author hyeyoom
 */
final class GaramFlow {

    private static final int UNDEFINED_PORT = -1;

    private int port = UNDEFINED_PORT;

    private final EmbeddedServer embeddedServer;
    private final GaramFactory factory = new DefaultGaramFactory();

    private GaramFlow() {
        EmbeddedServerFactory embeddedServerFactory = new DefaultEmbeddedServerFactory();
        embeddedServer = embeddedServerFactory.getEmbeddedServer(EmbeddedServerFactory.Type.JETTY);
    }

    static GaramFlow getDefault() {
        return new GaramFlow();
    }

    void addHandler(String path, RequestHandler handler, RequestMethod method) {
        final String alias = makeAliasWithPathAndMethod(path, method);
        factory.registerGaram(alias, handler);
    }

    private String makeAliasWithPathAndMethod(String path, RequestMethod method) {
        return String.format("%s:%s", path, method);
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
            embeddedServer.startServer();
        } catch (Exception e) {
            embeddedServer.abort();
        }
    }
}
