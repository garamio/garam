package io.garam.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DefaultGaramFactory test")
class DefaultGaramFactoryTest {

    private GaramFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DefaultGaramFactory();
    }

    @DisplayName("등록한 인스턴스를 가져와서 사용해본다.")
    @Test
    void registerAndGet() {
        // given
        final String expected = "garam";
        final Fixture instance = new Fixture(expected);

        // when
        final String alias = "key";
        factory.registerGaram(alias, instance);

        // then
        final Fixture instanceFromContainer = factory.getGaram(alias, Fixture.class);
        assertThat(instanceFromContainer).isNotNull();
        assertThat(instanceFromContainer.getName()).isEqualTo(expected);
    }

    static class Fixture {
        private final String name;

        public Fixture(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}