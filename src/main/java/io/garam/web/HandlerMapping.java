package io.garam.web;

import io.garam.web.http.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * first class collection for handlers
 *
 * @author hyeyoom
 */
public final class HandlerMapping {

    private final Map<HandlerKey, HandlerExecutor> executorMap;

    public HandlerMapping(Map<HandlerKey, HandlerExecutor> executorMap) {
        this.executorMap = executorMap;
    }

    public HandlerExecutor getHandler(HttpServletRequest request) {
        final String path = request.getRequestURI();
        final RequestMethod method = RequestMethod.valueOf(request.getMethod());
        return getHandler(new HandlerKey(path, method));
    }

    public HandlerExecutor getHandler(HandlerKey key) {
        return executorMap.get(key);
    }
}
