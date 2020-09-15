package io.garam.examples;

import io.garam.web.Garam;

public class Application {

    public static void main(String[] args) {
        Garam.get("/", ctx -> {
        });
        Garam.port(1234);
        Garam.run();
    }
}
