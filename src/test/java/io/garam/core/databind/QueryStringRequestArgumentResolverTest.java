package io.garam.core.databind;

import io.garam.core.http.GaramHttpRequest;
import io.garam.core.http.Request;
import io.garam.fixtures.MockHttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("요청에서 Query String을 통한 인자 매핑 테스트")
class QueryStringRequestArgumentResolverTest {

    private final String uri = "/test?param1=test";

    @DisplayName("QueryString이 요청에 존재하면 supports 메서드의 결과 값은 true")
    @Test
    void testSupports() {
        final MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setRequestURI(uri);
        final Request request = new GaramHttpRequest(mockHttpServletRequest);

        final RequestArgumentResolver resolver = new QueryStringRequestArgumentResolver();
        assertThat(resolver.supports(request)).isTrue();
    }

    @DisplayName("QueryString으로부터 객체를 추출할 수 있는지 테스트")
    @Test
    void testResolveArgument() {
        final MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setRequestURI(uri);
        final Request request = new GaramHttpRequest(mockHttpServletRequest);

        final RequestArgumentResolver resolver = new QueryStringRequestArgumentResolver();
        final DummyData data = resolver.resolveArgument(request, DummyData.class);
        assertThat(data).isNotNull();
        assertThat(data.getParam1()).isEqualTo("test");
    }

    public static class DummyData {
        private String param1;

        public DummyData() {
        }

        public String getParam1() {
            return param1;
        }
    }
}