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
        // First check if a system property is set, otherwise fallback to the properties file value
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = properties.getProperty("browser", "chrome"); // Default to chrome if not set
        }
        return browser;
    }

    public static Map<String, Boolean> getBrowserOptions() {
        Map<String, Boolean> options = new HashMap<>();

        // Use system properties for the options if they exist
        boolean headless = Boolean.parseBoolean(System.getProperty("browser_headless", properties.getProperty("browser_headless", "false")));
        boolean maximized = Boolean.parseBoolean(System.getProperty("browser_maximized", properties.getProperty("browser_maximized", "true")));
        boolean incognito = Boolean.parseBoolean(System.getProperty("browser_incognito", properties.getProperty("browser_incognito", "false")));

        options.put("headless", headless);
        options.put("maximized", maximized);
        options.put("incognito", incognito);

        // Print out values for debugging purposes
        System.out.println("Headless: " + headless);
        System.out.println("Maximized: " + maximized);
        System.out.println("Incognito: " + incognito);

        return options;
    }

    public static int getImplicitTime() {
        // First check if a system property is set, otherwise fallback to the properties file value
        String implicitTime = System.getProperty("implicit_time");
        if (implicitTime == null) {
            implicitTime = properties.getProperty("implicit_time", "10"); // Default to 10 seconds if not set
        }
        return Integer.parseInt(implicitTime);
    }
}
