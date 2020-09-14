package io.garam.web.server;

/**
 * Interface to be implemented by objects that have responsible for creating embedded servers.
 *
 * @author hyeyoom
 */
public interface EmbeddedServerFactory {

    EmbeddedServer getEmbeddedServer(Type type);

    enum Type {
        JETTY
    }
}
