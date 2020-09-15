package io.garam.web;

import io.garam.web.handlers.RequestHandler;
import io.garam.web.http.RequestMethod;

/**
 * Convenient wrapping module for web layer.
 *
 * @author hyeyoom
 */
public final class Garam {

    private Garam() {
        // prevent to instantiate
    }

    private static class SingletonHolder {
        private static final GaramFlow INSTANCE = GaramFlow.getDefault();
    }

    private static GaramFlow getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void get(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void head(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void post(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void put(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void delete(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void connect(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void options(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void trace(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void patch(String path, RequestHandler handler, RequestMethod method) {
        getInstance().addHandler(path, handler, method);
    }

    public static void port(int port) {
        getInstance().port(port);
    }

    public static void run() {
        try {
            getInstance().flow();
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred during abortion.");
        }
    }
}
