package io.garam.web.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultContext implements Context {

    private final Request request;
    private final Response response;

    public DefaultContext(HttpServletRequest request, HttpServletResponse response) {
        this(new GaramHttpRequest(request), new GaramHttpResponse(response));
    }

    public DefaultContext(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public Request request() {
        return null;
    }

    @Override
    public Response response() {
        return null;
    }
}
