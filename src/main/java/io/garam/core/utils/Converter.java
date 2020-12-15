package io.garam.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.garam.core.utils.exceptions.DataConversionException;

public final class Converter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String stringify(Object obj) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new DataConversionException("An error occurred during the json conversion", e);
        }
    }
}
