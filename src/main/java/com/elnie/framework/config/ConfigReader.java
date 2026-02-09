package com.elnie.framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties props = new Properties();

    public ConfigReader() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties not found in src/test/resources");
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String get(String key) {
        String override = System.getProperty(key);
        return (override != null && !override.isBlank()) ? override : props.getProperty(key);
    }

    public boolean getBoolean(String key) { return Boolean.parseBoolean(get(key)); }
    public int getInt(String key) { return Integer.parseInt(get(key)); }
}
