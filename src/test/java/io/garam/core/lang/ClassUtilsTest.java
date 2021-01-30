package io.garam.core.lang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("클래스 유틸 테스트")
class ClassUtilsTest {

    @Test
    void testInstantiation() throws Exception {

        // given
        final String v1 = "test";
        final long v2 = 10L;
        final float v3 = 3.141592f;
        final HashMap<String, String> map = new HashMap<>();
        map.put("value1", v1);
        map.put("value2", String.valueOf(v2));
        map.put("value3", String.valueOf(v3));

        // when
        final DummyData data = ClassUtils.instantiate(DummyData.class, ClassUtils.ParameterMap.of(map));

        // then
        assertThat(data).isNotNull();
        assertThat(data.getValue1()).isEqualTo(v1);
        assertThat(data.getValue2()).isEqualTo(v2);
        assertThat(data.getValue3()).isEqualTo(v3);
    }

    private static class DummyData {
        private String value1;
        private Long value2;
        private Float value3;

        public DummyData() {
        }

        public DummyData(String value1, Long value2, Float value3) {
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
        }

        public String getValue1() {
            return value1;
        }

        public Long getValue2() {
            return value2;
        }

        public Float getValue3() {
            return value3;
        }
    }
}