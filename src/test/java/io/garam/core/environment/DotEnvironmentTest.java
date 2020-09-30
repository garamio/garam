package io.garam.core.environment;

import io.garam.core.utils.FileUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DotEnvironment module test")
class DotEnvironmentTest {

    private static final String TEST_ENV = "test";
    private static final String KEY = "SERVICE_PORT";
    private static final String EXPECTED = "1234";
    private static final String TEST_FILE_NAME = "abc_config_abc";

    @DisplayName("JVM 파라미터로 환경을 지정하고 classpath에 위치하는 .env 파일을 읽는지 검사.")
    @Test
    void testEnvironmentArgumentPassedThroughJVMParameter() throws Exception {

        // given
        System.setProperty("env", TEST_ENV);
        writeOnTestFixtureEnvFile(String.format("%s=%s", KEY, EXPECTED));

        // when
        final DotEnvironment dotEnv = new DotEnvironment();
        final String actual = dotEnv.getProperty(KEY);

        // then
        assertThat(actual).isEqualTo(EXPECTED);
    }

    @DisplayName("JVM 파라미터로 설정파일 경로를 지정한다.")
    @Test
    void testEnvironmentFilePathArgumentPassedThroughJVMParameter() throws Exception {

        // given
        final String filePath = writeDummyFile(TEST_FILE_NAME, String.format("%s=%s", KEY, EXPECTED));
        System.setProperty("envFilePath", filePath);

        // when
        final DotEnvironment dotEnv = new DotEnvironment();
        final String actual = dotEnv.getProperty(KEY);

        // then
        assertThat(actual).isEqualTo(EXPECTED);
    }

    @AfterEach
    void tearDown() {
        removeDummyFile(TEST_FILE_NAME);
    }

    private String writeDummyFile(String fileName, String... contentToWrite) throws IOException {
        final File fixtureFile = new File(fileName);
        writeContentOnFile(fixtureFile, contentToWrite);
        return fixtureFile.getAbsolutePath();
    }

    private void removeDummyFile(String filePath) {
        final File fileToRemove = new File(filePath);
        fileToRemove.delete();
    }

    private void writeOnTestFixtureEnvFile(String... contentToWrite) throws IOException {
        final File fixtureFile = FileUtil.getFileFromClasspath(".env-test");
        if (fixtureFile == null) {
            throw new IOException("Unable to open file.");
        }
        writeContentOnFile(fixtureFile, contentToWrite);
    }

    private void writeContentOnFile(File fixtureFile, String... contentToWrite) throws IOException {
        try (
                final FileWriter fw = new FileWriter(fixtureFile);
                final BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (String s : contentToWrite) {
                bw.write(s);
                if (!s.contains("\r\n")) {
                    bw.write("\r\n");
                }
            }
        }
    }
}