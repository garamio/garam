package io.garam.web.server;

/**
 * Interface to be implemented by objects that provide http server.
 *
 * @author hyeyoom
 */
public interface EmbeddedServer {

    /**
     * @throws Exception if error occurred during execution.
     */
    void startServer() throws Exception;
}
