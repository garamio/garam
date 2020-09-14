package io.garam.web.server;

/**
 * Interface to be implemented by objects that provide http server.
 *
 * @author hyeyoom
 */
public interface EmbeddedServer {

    void start() throws Exception;
}
