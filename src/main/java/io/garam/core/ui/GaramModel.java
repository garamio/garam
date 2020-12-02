package io.garam.core.ui;

import java.util.HashMap;
import java.util.Map;

public class GaramModel implements Model {

    private final Map<String, Object> map;

    public GaramModel() {
        this(new HashMap<>());
    }

    public GaramModel(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public Model addAttribute(String attributeName, Object attributeValue) {
        map.put(attributeName, attributeValue);
        return this;
    }

    @Override
    public Map<String, Object> asMap() {
        return map;
    }
}
