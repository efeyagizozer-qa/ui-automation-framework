package com.efeozer.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();

    static {

        try {

            FileInputStream file =
                    new FileInputStream("src/configuration.properties");

            properties.load(file);

            file.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Configuration.properties file not found.");
        }
    }

    private ConfigurationReader() {
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }

}