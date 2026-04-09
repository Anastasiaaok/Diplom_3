package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        if (browser.equalsIgnoreCase("yandex")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(); // Яндекс = Chromium
        }

        throw new RuntimeException("Browser not supported");
    }
}