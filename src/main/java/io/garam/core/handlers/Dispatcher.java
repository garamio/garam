package io.garam.core.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Dispatcher {

    /**
     * @param request  request
     * @param response response
     * @return true if request is handled.
     */
    boolean dispatch(HttpServletRequest request, HttpServletResponse response);
}
