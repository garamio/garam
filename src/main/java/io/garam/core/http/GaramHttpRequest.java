package io.garam.core.http;

import io.garam.core.databind.DataBinder;

import javax.servlet.http.HttpServletRequest;

public class GaramHttpRequest implements Request {

    private final HttpServletRequest request;

    public GaramHttpRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getHeader(String name) {
        return request.getHeader(name);
    }

    @Override
    public String uri() {
        return request.getRequestURI();
    }

    @Override
    public String parameter(String name) {
        return request.getParameter(name);
    }

    @Override
    public <T> T bind(Class<T> type) {
        return DataBinder.getBoundData(request, type);
    }
}
