package io.garam.web.handlers;

import io.garam.web.HandlerExecutor;
import io.garam.web.HandlerMapping;
import io.garam.web.Middlewares;
import io.garam.web.http.Context;
import io.garam.web.http.DefaultContext;
import io.garam.web.ui.MustacheTemplateEngine;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.session.SessionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RootHandler extends SessionHandler {

    private final HandlerMapping handlerMapping;
    private final Middlewares middlewares;

    public RootHandler(HandlerMapping handlerMapping, Middlewares middlewares) {
        this.handlerMapping = handlerMapping;
        this.middlewares = middlewares;
    }

    @Override
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        final HandlerExecutor handler = getHandlerExecutor(request);
        if (handler == null) {
            return;
        }
        baseRequest.setHandled(true);
        // TODO: 지금은 임시로 템플릿 엔진을 지정했지만 설정 구조를 잡고 난 후 분리한다.
        final Context context = new DefaultContext(request, response, new MustacheTemplateEngine());
        pre(context);
        handler.execute(context);
        post(context);
    }

    private void pre(Context context) {
        for (Middleware beforeMiddleware : middlewares.getBeforeMiddlewares()) {
            beforeMiddleware.execute(context);
        }
        around(context);
    }

    private void post(Context context) {
        for (Middleware afterMiddleware : middlewares.getAfterMiddlewares()) {
            afterMiddleware.execute(context);
        }
        around(context);
    }

    private void around(Context context) {
        for (Middleware aroundMiddleware : middlewares.getAroundMiddlewares()) {
            aroundMiddleware.execute(context);
        }
    }

    private HandlerExecutor getHandlerExecutor(HttpServletRequest request) {
        // TODO: 404 handler required.
        return handlerMapping.getHandler(request);
    }
}
