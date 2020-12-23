package io.garam.core.databind;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

public class RequestArgumentResolverComposite implements RequestArgumentResolver {

    private final List<RequestArgumentResolver> resolvers = new LinkedList<>();

    @Override
    public boolean supports(HttpServletRequest request) {
        return false;
    }

    @Override
    public <T> T getBoundData(HttpServletRequest request, Class<T> type) {
        return null;
    }
}
