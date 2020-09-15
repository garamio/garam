package io.garam.web;

import io.garam.web.http.RequestMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HandlerKey test")
class HandlerKeyTest {


    @DisplayName("동일성 테스트")
    @Test
    void testEquality() {

        // given
        final String path = "/";
        final RequestMethod method = RequestMethod.GET;
        final HandlerKey hk1 = new HandlerKey(path, method);
        final HandlerKey hk2 = new HandlerKey(path, method);

        // then
        assertThat(hk1).isEqualTo(hk2);
        assertThat(hk1 == hk2).isFalse();
    }
}