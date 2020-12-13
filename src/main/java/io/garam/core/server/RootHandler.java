package io.garam.core.server;

import io.garam.core.handlers.Dispatcher;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.session.SessionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RootHandler extends SessionHandler {

    private final Dispatcher rootDispatcher;

    public RootHandler(Dispatcher rootDispatcher) {
        this.rootDispatcher = rootDispatcher;
    }

    @Override
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        final boolean result = rootDispatcher.dispatch(request, response);
        baseRequest.setHandled(result);
    }
}
