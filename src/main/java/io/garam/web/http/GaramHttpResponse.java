package io.garam.web.http;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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
        response.setContentType(contentType);
        return this;
    }

    @Override
    public Response text(String body) {
        write(body.getBytes());
        return this;
    }

    private void write(byte[] raw) {
        try (final OutputStream os = response.getOutputStream()) {
            os.write(raw);
        } catch (IOException e) {
            // TODO: error handling structure required.
            throw new IllegalStateException("");
        }
    }

}
