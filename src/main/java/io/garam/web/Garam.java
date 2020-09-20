package io.garam.web;

import io.garam.web.handlers.Middleware;
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

    public static void get(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.GET);
    }

    public static void head(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.HEAD);
    }

    public static void post(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.POST);
    }

    public static void put(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.PUT);
    }

    public static void delete(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.DELETE);
    }

    public static void connect(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.CONNECT);
    }

    public static void options(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.OPTIONS);
    }

    public static void trace(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.TRACE);
    }

    public static void patch(String path, RequestHandler handler) {
        getInstance().addHandler(path, handler, RequestMethod.PATCH);
    }

    public static void port(int port) {
        getInstance().port(port);
    }

    public static void use(Middleware ...middlewares) {
        getInstance().use(middlewares);
    }

    public static void before(Middleware ...middlewares) {
        getInstance().before(middlewares);
    }

    public static void after(Middleware ...middlewares) {
        getInstance().after(middlewares);
    }

    public static void run() {
        try {
            getInstance().flow();
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred during abortion.");
        }
    }
}
