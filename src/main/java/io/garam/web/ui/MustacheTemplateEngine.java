package io.garam.web.ui;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MustacheTemplateEngine implements TemplateEngine {

    private static final Mustache.Compiler compiler = Mustache.compiler();

    private final Map<String, Template> cachedTemplates = new HashMap<>();
    private final String rootPath = "/templates";
    private final String extension = "mustache";

    @Override
    public String render(String templateName, Model model) {
        Template template = getTemplateFromCache(templateName);
        if (template == null) {
            template = readTemplate(templateName);
        }
        return template.execute(model.asMap());
    }

    private Template readTemplate(String templateName) {
        final String filename = String.format("%s.%s", templateName, extension);
        final Path filePath = Paths.get(rootPath, filename);
        try (
                final InputStream is = this.getClass().getResourceAsStream(filePath.toString().replace("\\", "/"));
                final BufferedInputStream bis = new BufferedInputStream(is);
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            int result = bis.read();
            while (result != -1) {
                byteArrayOutputStream.write((byte) result);
                result = bis.read();
            }
            final String templateString = byteArrayOutputStream.toString(StandardCharsets.UTF_8);
            final Template template = compiler.compile(templateString);
            cache(templateName, template);
            return template;
        } catch (IOException e) {
            // TODO: 임시처리 제거 필요.
            throw new IllegalStateException("");
        }
    }

    private void cache(String templateName, Template template) {
        cachedTemplates.put(templateName, template);
    }

    private Template getTemplateFromCache(String templateName) {
        return cachedTemplates.get(templateName);
    }
}
