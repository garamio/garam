package io.garam.core.databind;

import io.garam.core.http.Request;
import io.garam.core.utils.Converter;

public class JsonRequestArgumentResolver implements RequestArgumentResolver {

    @Override
    public boolean supports(Request request) {
        return request.getContentType().contains("application/json");
    }

    @Override
    public <T> T resolveArgument(Request request, Class<T> type) {
        final String json = new String(request.body());
        return Converter.toObject(json, type);
    }
}
