package io.garam.examples;

import io.garam.examples.config.PageInitializer;
import io.garam.examples.member.controller.MemberController;
import io.garam.web.Garam;

public class Application {

    public static void main(String[] args) {
        PageInitializer.init();
        new MemberController();
        Garam.port(1234);
        Garam.run();
    }
}
