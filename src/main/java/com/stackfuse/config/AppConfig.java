package com.stackfuse.config;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static final String API_KEY ;
    public static final String BASE_URL = "https://api.football-data.org/v4";
    static {
        try {
            Properties props = new Properties();
            InputStream input = AppConfig.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");
            props.load(input);
            API_KEY = props.getProperty("API_KEY");
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties");
        }
    }
}
