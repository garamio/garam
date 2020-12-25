package io.garam.core.databind;

import io.garam.core.http.Request;

public interface RequestArgumentResolver {

    boolean supports(Request request);

    <T> T resolveArgument(Request request, Class<T> type);
}
