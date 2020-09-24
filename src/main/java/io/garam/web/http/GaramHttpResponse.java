package io.garam.web.http;

import io.garam.web.utils.HttpServletUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GaramHttpResponse implements Response {

    private final HttpServletResponse response;

    public GaramHttpResponse(HttpServletResponse response) {
        this.response = response;
        this.response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
    }

    @Override
    public Response status(HttpStatus status) {
        response.setStatus(status.getCode());
        return this;
    }

    @Override
    public Response contentType(String contentType) {
        // TODO: 하드코딩 강제되는데 처리하시오
        response.setContentType(contentType);
        return this;
    }

    @Override
    public Response text(String body) {
        try {
            HttpServletUtil.write(response.getOutputStream(), body);
            return this;
        } catch (IOException e) {
            // TODO: error handling structure required.
            throw new IllegalStateException("");
        }
    }

    @Override
    public Response redirect(String path) {
        response.setStatus(HttpStatus.MOVED_PERMANENTLY.getCode());
        // TODO: 하드코딩 처리하시오
        response.setHeader("Location", path);
        return this;
    }

    @Override
    public Response header(String name, String value) {
        response.setHeader(name, value);
        return this;
    }

}
