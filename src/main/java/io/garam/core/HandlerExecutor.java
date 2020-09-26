package io.garam.core;

import io.garam.core.handlers.RequestHandler;
import io.garam.core.http.Context;

public final class HandlerExecutor {

    private final RequestHandler handler;

    public HandlerExecutor(RequestHandler handler) {
        this.handler = handler;
    }

    public void execute(Context context) {
        handler.handle(context);
    }
}
