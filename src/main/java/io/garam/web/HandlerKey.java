package io.garam.web;

import io.garam.web.http.RequestMethod;

import java.util.Objects;

public final class HandlerKey {

    private final String path;
    private final RequestMethod method;

    public HandlerKey(String path, RequestMethod method) {
        this.path = path;
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return Objects.equals(path, that.path) &&
                method == that.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, method);
    }
    
}
