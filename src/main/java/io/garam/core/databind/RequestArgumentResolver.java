package io.garam.core.databind;

import javax.servlet.http.HttpServletRequest;

public interface RequestArgumentResolver {

    boolean supports(HttpServletRequest request);

    <T> T getBoundData(HttpServletRequest request, Class<T> type);
}
