package io.garam.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.garam.core.utils.exceptions.DataConversionException;

public final class Converter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String stringify(Object obj, boolean pretty) {
        try {
            if (pretty) {
                return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            }
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new DataConversionException("An error occurred during the json conversion", e);
        }
    }

    public static String stringify(Object obj) {
        return stringify(obj, true);
    }

    public static <T> T toObject(String json, Class<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new DataConversionException("An error occurred during the json conversion", e);
        }
    }
}
