package io.garam.core.handlers;

import io.garam.core.HandlerExecutor;
import io.garam.core.HandlerMapping;
import io.garam.core.Middlewares;
import io.garam.core.http.Context;
import io.garam.core.http.DefaultContext;
import io.garam.core.http.HttpStatus;
import io.garam.core.ui.StaticFileHandler;
import io.garam.core.ui.TemplateEngine;
import io.garam.core.utils.HttpServletUtil;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.session.SessionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RootHandler extends SessionHandler {

    private final HandlerMapping handlerMapping;
    private final Middlewares middlewares;
    private final TemplateEngine templateEngine;
    private final StaticFileHandler staticFileHandler = new StaticFileHandler();

    public RootHandler(HandlerMapping handlerMapping, Middlewares middlewares, TemplateEngine templateEngine) {
        this.handlerMapping = handlerMapping;
        this.middlewares = middlewares;
        this.templateEngine = templateEngine;
    }

    @Override
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        final HandlerExecutor handler = getHandlerExecutor(request);
        if (handler == null) {
            handleNotFoundHandler(baseRequest, request, response);
            return;
        }
        baseRequest.setHandled(true);
        final Context context = new DefaultContext(request, response, templateEngine);
        pre(context);
        handler.execute(context);
        post(context);
    }

    // TODO: HandlerExecutor
    private void handleNotFoundHandler(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
        final String path = request.getRequestURI();
        final String staticFile = staticFileHandler.readStaticFile(path);
        if (staticFile == null) {
            return;
        }
        baseRequest.setHandled(true);
        responseStatic(response, path, staticFile);
    }

    private void responseStatic(HttpServletResponse response, String path, String staticFile) {
        try {
            final String mimeType = staticFileHandler.getMimeType(path);
            response.setStatus(HttpStatus.OK.getCode());
            response.setContentType(mimeType);
            response.setContentLength(staticFile.getBytes().length);
            HttpServletUtil.write(response.getOutputStream(), staticFile);
        } catch (Throwable ignore) {
            ignore.printStackTrace();
        }
    }

    private void pre(Context context) {
        middlewares.executeBefore(context);
        around(context);
    }

    private void post(Context context) {
        middlewares.executeAfter(context);
        around(context);
    }

    private void around(Context context) {
        middlewares.executeAround(context);
    }

    private HandlerExecutor getHandlerExecutor(HttpServletRequest request) {
        // TODO: 404 handler required.
        return handlerMapping.getHandler(request);
    }
}
