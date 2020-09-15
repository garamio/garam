package io.garam.web;

import io.garam.web.handlers.RequestHandler;
import io.garam.web.http.Context;

public final class HandlerExecutor {

    private final RequestHandler handler;

    public HandlerExecutor(RequestHandler handler) {
        this.handler = handler;
    }

    public void execute(Context context) {
        handler.handle(context);
    }
}
