package io.garam.core.server;

/**
 * Interface to be implemented by objects that provide http server.
 *
 * @author hyeyoom
 */
public interface EmbeddedServer {

    /**
     * @param configuration configuration
     */
    void init(EmbeddedServerConfiguration configuration);

    /**
     * @throws Exception if error occurred during execution.
     */
    void startServer() throws Exception;

    /**
     * @throws Exception if error occurred during abortion.
     */
    void abort() throws Exception;
}
