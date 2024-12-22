package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver createDriver() {
        String browser = ConfigReader.getBrowser();
        Map<String, Boolean> browserOptions = ConfigReader.getBrowserOptions();
        int implicitTime = ConfigReader.getImplicitTime();


        WebDriver driver;

        // Initialize options and apply common settings for each browser
        switch (browser.toLowerCase()) {
            case "chrome":
//                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                applyChromeOptions(chromeOptions, browserOptions);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                applyFirefoxOptions(firefoxOptions, browserOptions);
                driver = new FirefoxDriver(firefoxOptions);
                break;


            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Set implicit wait time

        driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
        return driver;
    }

    private static void applyChromeOptions(ChromeOptions options, Map<String, Boolean> browserOptions) {
        if (browserOptions.get("headless")) {
            options.addArguments("--headless");
        }
        if (browserOptions.get("maximized")) {
            options.addArguments("--start-maximized");
        }
        if (browserOptions.get("incognito")) {
            options.addArguments("--incognito");
        }
    }

    private static void applyFirefoxOptions(FirefoxOptions options, Map<String, Boolean> browserOptions) {
        if (browserOptions.get("headless")) {
            options.addArguments("--headless");
        }
        if (browserOptions.get("maximized")) {
            options.addArguments("--start-maximized");
        }
        if (browserOptions.get("incognito")) {
            options.addArguments("--private");
        }
    }



}
