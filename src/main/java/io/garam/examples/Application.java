package io.garam.examples;

import io.garam.examples.member.controller.MemberController;
import io.garam.web.Garam;
import io.garam.web.ui.GaramModel;

public class Application {

    public static void main(String[] args) {
        Garam.get("/", ctx -> ctx.render("index", new GaramModel()));
        new MemberController();
        Garam.port(1234);
        Garam.run();
    }
}
