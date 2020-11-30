package io.garam.core.environment;

import io.garam.core.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dotenv-like environment &amp; configuration manager.
 * <p>
 * Rule for environment
 * .env-{env_name}
 *
 * @author hyeyoom
 */
public class DotEnvironment implements PropertyResolver {

    private static final Logger log = LoggerFactory.getLogger(DotEnvironment.class);

    private static final String ENV_KEY_NAME = "env";
    private static final String ENV_FILE_KEY_NAME = "envFilePath";
    private static final String DEFAULT_ENV = "default";
    private static final String DELIMITER = "=";

    private final Map<String, String> properties = new HashMap<>();

    public DotEnvironment() {
        final String currentEnvironment = getCurrentEnvProperty();
        final File envFile = getCurrentEnvFile(currentEnvironment);
        readPropertiesFromFile(envFile);
    }

    private void readPropertiesFromFile(File envFile) {
        try {
            final List<String> lines = Files.readAllLines(envFile.toPath());
            for (String line : lines) {
                extract(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void extract(String line) {
        final String[] keyAndValue = line.split(DELIMITER);
        properties.put(keyAndValue[0], keyAndValue[1]);
    }

    private String getCurrentEnvProperty() {
        final String envProperty = System.getProperty(ENV_KEY_NAME);
        return envProperty != null ? envProperty : DEFAULT_ENV;
    }

    private File getCurrentEnvFile(String currentEnvironment) {
        final String envFileProperty = System.getProperty(ENV_FILE_KEY_NAME);
        if (envFileProperty != null) {
            return new File(envFileProperty);
        }
        final String fileName = String.format(".env-%s", currentEnvironment);
        return FileUtil.getFileFromClasspath(fileName);
    }

    @Override
    public String getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        final String property = getProperty(key);
        if (property == null) {
            return defaultValue;
        }
        return property;
    }
}
