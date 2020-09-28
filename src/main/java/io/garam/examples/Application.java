package io.garam.examples;

import io.garam.core.Garam;
import io.garam.core.ui.MustacheTemplateEngine;
import io.garam.examples.config.PageInitializer;
import io.garam.examples.member.controller.MemberController;

public class Application {

    public static void main(String[] args) {
        PageInitializer.init();
        new MemberController();
        final MustacheTemplateEngine templateEngine = new MustacheTemplateEngine();
        Garam.template(templateEngine);
        Garam.port(1234);
        Garam.run();
    }
}
