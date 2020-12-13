package io.garam.core.server;

import io.garam.core.handlers.Dispatcher;
import io.garam.core.handlers.RootDispatcher;
import org.eclipse.jetty.server.Server;

/**
 * Root handler is located inside the server for convenience, but it will be extracted from server.
 *
 * @author hyeyoom
 */
public class JettyEmbeddedServer implements EmbeddedServer {

    private Server server;

    @Override
    public void init(EmbeddedServerConfiguration configuration) {
        server = new Server(configuration.getPort());
        final Dispatcher dispatcher = new RootDispatcher(
                configuration.getHandlerMapping(),
                configuration.getMiddlewares(),
                configuration.getTemplateEngine()
        );
        server.setHandler(new RootHandler(dispatcher));
    }

    @Override
    public void startServer() throws Exception {
        server.start();
        server.join();
    }

    @Override
    public void abort() throws Exception {
        server.stop();
        server.destroy();
    }

}
