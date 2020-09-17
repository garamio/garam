package io.garam.web.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultContext implements Context {

    private final Request request;
    private final Response response;
    private final Session session;

    public DefaultContext(HttpServletRequest request, HttpServletResponse response) {
        this(
                new GaramHttpRequest(request),
                new GaramHttpResponse(response),
                new GaramHttpSession(request.getSession(true))
        );
    }

    public DefaultContext(Request request, Response response, Session session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Response response() {
        return response;
    }

    @Override
    public Session session() {
        return session;
    }
}
