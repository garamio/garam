package io.garam.web.http;

import javax.servlet.http.HttpServletRequest;

public class GaramHttpRequest implements Request {

    private final HttpServletRequest request;

    public GaramHttpRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String parameter(String name) {
        return request.getParameter(name);
    }
}
