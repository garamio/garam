package io.garam.core.databind;

import io.garam.core.http.Request;

public class FormDataRequestArgumentResolver extends ParameterMapRequestArgumentResolver {

    @Override
    public boolean supports(Request request) {
        return request.getContentType().contains("application/x-www-form-urlencoded");
    }
}
