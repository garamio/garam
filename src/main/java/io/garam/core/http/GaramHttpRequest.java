package io.garam.core.http;

import io.garam.core.databind.RequestArgumentResolverComposite;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class GaramHttpRequest implements Request {

    private static final RequestArgumentResolverComposite RESOLVER = new RequestArgumentResolverComposite();

    private final HttpServletRequest request;

    public GaramHttpRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getHeader(String name) {
        return request.getHeader(name);
    }

    @Override
    public String uri() {
        return request.getRequestURI();
    }

    @Override
    public String getContentType() {
        return request.getContentType();
    }

    @Override
    public String getQueryString() {
        return request.getQueryString();
    }

    @Override
    public String getParameter(String name) {
        return request.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return request.getParameterMap();
    }

    @Override
    public byte[] body() {
        try {
            final InputStream is = request.getInputStream();
            final int length = request.getContentLength();
            if (length > 0) {
                final byte[] bytes = new byte[length];
                final int read = is.read(bytes);
                return bytes;
            }
            return null;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read body from request.", e);
        }
    }

    @Override
    public <T> T bind(Class<T> type) {
        return RESOLVER.resolveArgument(this, type);
    }
}
