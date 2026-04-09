package tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @Step("Открытие главной страницы")
    public void openMainPage() {
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        openMainPage(); // ВАЖНО
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
