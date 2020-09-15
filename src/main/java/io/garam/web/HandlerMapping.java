package io.garam.web;

import java.util.HashMap;
import java.util.Map;

/**
 * first class collection for handlers
 *
 * @author hyeyoom
 */
public final class HandlerMapping {

    private final Map<HandlerKey, HandlerExecutor> executorMap;

    public HandlerMapping() {
        this(new HashMap<>());
    }

    public HandlerMapping(Map<HandlerKey, HandlerExecutor> executorMap) {
        this.executorMap = executorMap;
    }

    public HandlerExecutor getHandler(HandlerKey key) {
        return executorMap.get(key);
    }
}
