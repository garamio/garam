package io.garam.web.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public final class FileUtil {

    public static File getFileFromClasspath(String path) {
        try {
            final URL resource = FileUtil.class.getClassLoader().getResource(path);
            if (resource == null) {
                return null;
            }
            return Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static String getMimeTypeByExtension(String extension) {
        return MimeType.getMimeType(extension);
    }
}
