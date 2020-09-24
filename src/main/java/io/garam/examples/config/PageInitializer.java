package io.garam.examples.config;

import io.garam.web.Garam;
import io.garam.web.ui.GaramModel;

public class PageInitializer {

    public static void init() {
        Garam.get("/", ctx -> ctx.render("index", new GaramModel()));
        Garam.get("/signup", ctx -> ctx.render("signup", new GaramModel()));
        Garam.get("/signin", ctx -> ctx.render("signin", new GaramModel()));
        Garam.get("/writepost", ctx -> ctx.render("writepost", new GaramModel()));
    }

}
