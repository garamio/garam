package io.garam.examples;

import io.garam.core.Garam;
import io.garam.core.http.HttpStatus;
import io.garam.core.ui.GaramModel;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Garam.get("/", ctx -> ctx
                .response()
                .status(HttpStatus.OK)
                .contentType("application/json")
                .text("{\"message\": \"안녕\"}")
        );
        final Map<String, Object> render = new HashMap<>();
        render.put("header", "message");
        Garam.get("/page", ctx -> ctx.render("index", new GaramModel(render)));
        Garam.port(1234);
        Garam.run();
    }
}
