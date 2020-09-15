package io.garam.examples;

import io.garam.web.Garam;
import io.garam.web.http.HttpStatus;

public class Application {

    public static void main(String[] args) {
        Garam.get("/", ctx -> ctx
                .response()
                .status(HttpStatus.OK)
                .contentType("application/json")
                .text("{\"message\": \"안녕\"}")
        );
        Garam.port(1234);
        Garam.run();
    }
}
