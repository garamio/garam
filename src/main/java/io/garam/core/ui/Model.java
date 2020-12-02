package io.garam.core.ui;

import java.util.Map;

/**
 * A holder for model attributes.
 *
 * @author hyeyoom
 */
public interface Model {

    /**
     * @param otherModel model to be merged into this model.
     * @return new merged model.
     */
    Model mergeAttributes(Model otherModel);

    /**
     * @param attributeName the name of model attribute
     * @param attributeValue the model attribute
     * @return the Model itself.
     */
    Model addAttribute(String attributeName, Object attributeValue);

    /**
     * @return returns the current model attributes as a map.
     */
    Map<String, Object> asMap();
}
