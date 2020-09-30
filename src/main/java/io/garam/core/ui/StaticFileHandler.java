package io.garam.core.ui;

import io.garam.core.utils.FileUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

// 임시
public class StaticFileHandler {

    private final String rootPath = "static";

    public String readStaticFile(String staticFileName) {
        final String path = getPath(staticFileName);
        final File file = FileUtil.getFileFromClasspath(path);
        if (file == null) {
            return null;
        }
        try (
                final InputStream is = new FileInputStream(file);
                final BufferedInputStream bis = new BufferedInputStream(is);
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            int result = bis.read();
            while (result != -1) {
                byteArrayOutputStream.write((byte) result);
                result = bis.read();
            }
            return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }

    public String getMimeType(String staticFileName) {
        final String path = getPath(staticFileName);
        final File file = FileUtil.getFileFromClasspath(path);
        if (file == null) {
            return null;
        }
        final String fileName = file.getName();
        final String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        return FileUtil.getMimeTypeByExtension(ext);
    }

    private String getPath(String staticFileName) {
        return Paths.get(rootPath, staticFileName).toString().replace("\\", "/");
    }
}
