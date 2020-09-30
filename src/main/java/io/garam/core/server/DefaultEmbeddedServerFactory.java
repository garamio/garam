package io.garam.core.server;

/**
 * Basic implementation of {@link EmbeddedServerFactory}.
 * Garam framework uses jetty server as default. Other WAS will be supported in future.
 *
 * @author hyeyoom
 */
public class DefaultEmbeddedServerFactory implements EmbeddedServerFactory {

    @Override
    public EmbeddedServer getEmbeddedServer(Type type) {
        return new JettyEmbeddedServer();
    }
}
