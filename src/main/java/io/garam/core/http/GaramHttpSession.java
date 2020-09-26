package io.garam.core.http;

import javax.servlet.http.HttpSession;

public class GaramHttpSession implements Session {

    private final HttpSession session;

    public GaramHttpSession(HttpSession session) {
        this.session = session;
    }
}
