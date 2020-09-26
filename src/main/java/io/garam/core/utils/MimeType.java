package io.garam.core.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link <a href="https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types">mozila document</a>}
 * {@link <a href="https://www.weonlydo.com/Mailbox/Help/MimeTypes.html">weonlydo document</a>}
 *
 * @author hyeyoom
 */
public enum MimeType {

    /**
     * Files
     */
    JS("application/javascript", of("js")),
    JSON("application/json", of("json")),
    CSS("text/css", of("css")),
    HTML("text/html", of("html", "htm")),

    /**
     * Images
     */
    JPEG("image/jpeg", of("jpg", "jpeg")),
    PNG("image/png", of("png")),
    GIF("image/gif", of("gif")),
    BMP("image/x-ms-bmp", of("bmp")),
    WEBP("image/webp", of("webp")),
    MPEG("video/mpeg", of("mpeg", "mpg")),

    /**
     * Videos
     */
    MP4("video/mp4", of("mp4", "m4v")),
    MKV("video/x-matroska", of("mkv")),
    WEBM("video/webm", of("webm"));

    private final String mimeType;
    private final Set<String> extensions;

    MimeType(String mimeType, Set<String> extensions) {
        this.mimeType = mimeType;
        this.extensions = extensions;
    }

    private static Set<String> of(String... suffixes) {
        return new HashSet<>(Arrays.asList(suffixes));
    }

    public static String getMimeType(String extension) {
        final String extensionLowerCase = extension.toLowerCase();
        for (MimeType value : values()) {
            if (value.extensions.contains(extensionLowerCase)) {
                return value.mimeType;
            }
        }
        return null;
    }
}