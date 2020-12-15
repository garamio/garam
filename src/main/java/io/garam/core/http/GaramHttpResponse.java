package io.garam.core.http;

import io.garam.core.utils.Converter;
import io.garam.core.utils.HttpServletUtil;

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
        // TODO: remove
        response.setContentType(contentType);
        return this;
    }

    @Override
    public Response redirect(String path) {
        response.setStatus(HttpStatus.FOUND.getCode());
        header("Location", path);
        return this;
    }

    @Override
    public Response header(String name, String value) {
        response.setHeader(name, value);
        return this;
    }

    @Override
    public Response text(HttpStatus status, String body) {
        try {
            status(status);
            contentType("text/plain;");
            HttpServletUtil.write(response.getOutputStream(), body);
            return this;
        } catch (IOException e) {
            // TODO: error handling structure required.
            throw new IllegalStateException("");
        }
    }

    @Override
    public Response html(HttpStatus status, String body) {
        try {
            status(status);
            contentType("text/html;");
            HttpServletUtil.write(response.getOutputStream(), body);
            return this;
        } catch (IOException e) {
            // TODO: error handling structure required.
            throw new IllegalStateException("");
        }
    }

    @Override
    public Response json(HttpStatus status, Object body) {
        status(status);
        contentType("application/json");
        final String json = Converter.stringify(body);
        try {
            HttpServletUtil.write(response.getOutputStream(), json);
        } catch (IOException e) {
            // TODO: error handling structure required.
            throw new IllegalStateException("");
        }
        return this;
    }

}
