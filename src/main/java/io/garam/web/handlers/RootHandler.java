package io.garam.web.handlers;

import io.garam.web.HandlerExecutor;
import io.garam.web.HandlerMapping;
import io.garam.web.http.Context;
import io.garam.web.http.DefaultContext;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.session.SessionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RootHandler extends SessionHandler {

    private final HandlerMapping handlerMapping;

    public RootHandler(HandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        final HandlerExecutor handler = handlerMapping.getHandler(request);
        if (handler == null) {
            // TODO: 404 handler required.
            return;
        }
        baseRequest.setHandled(true);
        final HttpSession session = request.getSession(true);
        System.out.println(session.getId());
        final Context context = new DefaultContext(request, response);
        handler.execute(context);
    }
}
