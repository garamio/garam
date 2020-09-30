package io.garam.core.ui;

/**
 * Interface to be implemented by objects that render template using their own syntax.
 *
 * @author hyeyoom
 */
public interface TemplateEngine {

    /**
     * @param templateName template to be rendered
     * @param model        parameter
     * @return rendered template
     */
    String render(String templateName, Model model);
}
