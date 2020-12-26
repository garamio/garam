package io.garam.core.databind;

import io.garam.core.http.Request;
import io.garam.core.lang.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class ParameterMapRequestArgumentResolver implements RequestArgumentResolver {

    private static final Logger log = LoggerFactory.getLogger(ParameterMapRequestArgumentResolver.class);

    @Override
    public <T> T resolveArgument(Request request, Class<T> type) {
        log.trace("request: {}, type: {}", request, type);
        final Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            map.put(entry.getKey(), entry.getValue()[0]);
        }
        return ClassUtils.instantiate(type, ClassUtils.ParameterMap.of(map));
    }
}
