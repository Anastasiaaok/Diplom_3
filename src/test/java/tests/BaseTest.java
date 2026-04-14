package tests;

import api.UserClient;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.UserGenerator;

import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected String accessToken;
    protected Map<String, String> user;

    protected UserClient userClient = new UserClient();

    @Step("Открытие главной страницы")
    public void openMainPage() {
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        openMainPage();

        // создаём пользователя
        user = UserGenerator.generateUser();

        var response = userClient.createUser(
                user.get("email"),
                user.get("password"),
                user.get("name")
        );

        accessToken = response.then().extract().path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
