package io.garam.core.http;

import javax.servlet.http.HttpSession;

public class GaramHttpSession implements Session {

    private final HttpSession session;

    public GaramHttpSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public void setAttribute(String name, Object value) {
        session.setAttribute(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return session.getAttribute(name);
    }

    @Override
    public void removeAttribute(String name) {
        session.removeAttribute(name);
    }

    @Override
    public void invalidate() {
        session.invalidate();
    }
}
