package io.garam.core.databind;

import io.garam.core.utils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DataBinder {

    private DataBinder() {
    }

    public static <T> T getBoundData(HttpServletRequest request, Class<T> clazz) {
        if (request.getContentType().contains("application/json")) {
            return convertJson(request, clazz);
        }
        return null;
    }

    private static <T> T convertJson(HttpServletRequest request, Class<T> clazz) {
        try {
            final StringBuilder sb = new StringBuilder();
            request.getReader().lines().forEach(sb::append);
            return Converter.toObject(sb.toString(), clazz);
        } catch (IOException e) {
            // TODO: 익셉션 처리
            e.printStackTrace();
        }
        return null;
    }
}
