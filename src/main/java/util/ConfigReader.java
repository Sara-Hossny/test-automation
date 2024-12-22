package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import java.util.Map;
import java.util.Properties;


import java.io.FileInputStream;


import java.util.HashMap;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/configuration.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome"); // Default to chrome if not set
    }

    public static Map<String, Boolean> getBrowserOptions() {
        Map<String, Boolean> options = new HashMap<>();
        options.put("headless", Boolean.parseBoolean(properties.getProperty("browser_headless", "false")));
        options.put("maximized", Boolean.parseBoolean(properties.getProperty("browser_maximized", "true")));
        options.put("incognito", Boolean.parseBoolean(properties.getProperty("browser_incognito", "false")));
        return options;
    }

    public static int getImplicitTime() {
        return Integer.parseInt(properties.getProperty("implicit_time", "10")); // Default to 10 seconds
    }
}
