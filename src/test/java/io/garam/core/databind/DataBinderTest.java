package io.garam.core.databind;

import io.garam.core.utils.Converter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("데이터 바인딩 모듈 테스트")
class DataBinderTest {

    RequestData requestData;

    @BeforeEach
    void setUp() {
        requestData = new RequestData(10L, "x@garam.io", "1234abcd");
    }

    @DisplayName("요청 바디가 JSON인 경우 바인딩 테스트")
    @Test
    void testDataBindingFromJson() throws Exception {

        // given
        final String json = Converter.stringify(requestData);
        final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        when(mockRequest.getContentType()).thenReturn("application/json;");
        final BufferedReader br = new BufferedReader(new StringReader(json));
        when(mockRequest.getReader()).thenReturn(br);

        // when
        final RequestData data = DataBinder.getBoundData(mockRequest, RequestData.class);

        // then
        assertThat(data).isNotNull();
        assertThat(data.getId()).isEqualTo(10L);
        assertThat(data.getEmail()).isEqualTo("x@garam.io");
        assertThat(data.getPassword()).isEqualTo("1234abcd");
    }

    @Test
    void testDataBindingFromFormData() throws Exception {

        // given

        // when

        // then
    }

    @Test
    void testDataBindingFromQueryString() throws Exception {

        // given

        // when

        // then
    }

    private static class RequestData {
        private Long id;
        private String email;
        private String password;

        public RequestData() {
        }

        public RequestData(Long id, String email, String password) {
            this.id = id;
            this.email = email;
            this.password = password;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}