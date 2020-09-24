package io.garam.web.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public final class HttpServletUtil {

    public static void write(OutputStream os, String content) {
        write(os, content.getBytes(StandardCharsets.UTF_8));
    }

    public static void write(OutputStream os, byte[] raw) {
        try {
            os.write(raw);
            os.flush();
        } catch (IOException e) {
            // TODO: error handling structure required.
            throw new IllegalStateException("");
        }
    }
}
