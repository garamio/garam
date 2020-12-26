package io.garam.core.databind;

import io.garam.core.http.GaramHttpRequest;
import io.garam.core.http.Request;
import io.garam.fixtures.MockHttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form 데이터 테스트")
class FormDataRequestArgumentResolverTest {

    @DisplayName("요청이 form 데이터인 경우 supports의 결과 값은 true")
    @Test
    void testSupports() {
        final MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setContentType("application/x-www-form-urlencoded");
        final Request request = new GaramHttpRequest(mockHttpServletRequest);

        final RequestArgumentResolver resolver = new FormDataRequestArgumentResolver();
        assertThat(resolver.supports(request)).isTrue();
    }

    @DisplayName("")
    @Test
    void testResolverArgument() {
        final String body = "param1=test";
        final MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setContentType("application/x-www-form-urlencoded");
        mockHttpServletRequest.setBody("param1=test");
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