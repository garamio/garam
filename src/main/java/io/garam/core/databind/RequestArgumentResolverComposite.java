package io.garam.core.databind;

import io.garam.core.http.Request;

import java.util.LinkedList;
import java.util.List;

public class RequestArgumentResolverComposite implements RequestArgumentResolver {

    private static final List<RequestArgumentResolver> resolvers = new LinkedList<>();

    static {
        resolvers.add(new JsonRequestArgumentResolver());
        resolvers.add(new FormDataRequestArgumentResolver());
        resolvers.add(new QueryStringRequestArgumentResolver());
    }


    @Override
    public boolean supports(Request request) {
        return getResolver(request) != null;
    }

    @Override
    public <T> T resolveArgument(Request request, Class<T> type) {
        for (RequestArgumentResolver resolver : resolvers) {
            if (resolver.supports(request)) {
                return resolver.resolveArgument(request, type);
            }
        }
        return null;
    }

    private RequestArgumentResolver getResolver(Request request) {
        for (RequestArgumentResolver resolver : resolvers) {
            if (resolver.supports(request)) {
                return resolver;
            }
        }
        return null;
    }
}
