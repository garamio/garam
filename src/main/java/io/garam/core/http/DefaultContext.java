package io.garam.core.http;

import io.garam.core.ui.GaramModel;
import io.garam.core.ui.Model;
import io.garam.core.ui.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultContext implements Context {

    private final Request request;
    private final Response response;
    private final Session session;
    private final Model model = new GaramModel();
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
    public Model model() {
        return model;
    }

    @Override
    public void render(String viewName, Model model) {
        final Model newModel = this.model.mergeAttributes(model);
        final String renderedPage = templateEngine.render(viewName, newModel);
        response.html(HttpStatus.OK, renderedPage);
    }
}
