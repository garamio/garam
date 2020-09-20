package io.garam.web.http;

import io.garam.web.ui.Model;
import io.garam.web.ui.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultContext implements Context {

    private final Request request;
    private final Response response;
    private final Session session;
    private final TemplateEngine templateEngine;

    public DefaultContext(HttpServletRequest request, HttpServletResponse response, TemplateEngine templateEngine) {
        this(
                new GaramHttpRequest(request),
                new GaramHttpResponse(response),
                new GaramHttpSession(request.getSession(true)),
                templateEngine
        );
    }

    public DefaultContext(Request request, Response response, Session session, TemplateEngine templateEngine) {
        this.request = request;
        this.response = response;
        this.session = session;
        this.templateEngine = templateEngine;
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

    @Override
    public void render(String templateName, Model model) {
        final String renderedPage = templateEngine.render(templateName, model);
        response.text(renderedPage);
    }
}
