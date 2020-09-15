package io.garam.web.http;

import javax.servlet.http.HttpServletResponse;

public class GaramHttpResponse implements Response {

    private final HttpServletResponse response;

    public GaramHttpResponse(HttpServletResponse response) {
        this.response = response;
    }
}
