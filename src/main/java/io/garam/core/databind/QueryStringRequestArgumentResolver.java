package io.garam.core.databind;

import io.garam.core.http.Request;

public class QueryStringRequestArgumentResolver extends ParameterMapRequestArgumentResolver {

    @Override
    public boolean supports(Request request) {
        return request.getQueryString() != null;
    }
}
