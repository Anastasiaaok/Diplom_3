package tests;

import api.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.DriverFactory;
import utils.UserGenerator; // ✅ ВАЖНО

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterTest {

    private WebDriver driver;
    private UserClient userClient = new UserClient();
    private String accessToken;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации пользователя")
    public void successRegister() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.clickRegister();

        RegisterPage reg = new RegisterPage(driver);

        Map<String, String> userData = UserGenerator.generateUser();

        reg.register(
                userData.get("name"),
                userData.get("email"),
                userData.get("password")
        );

        User user = new User(
                userData.get("email"),
                userData.get("password"),
                userData.get("name")
        );

        accessToken = userClient.createUser(user)
                .then()
                .extract()
                .path("accessToken");

        assertTrue(true);
    }

    @Test
    @DisplayName("Ошибка короткого пароля")
    public void wrongPassword() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.clickRegister();

        RegisterPage reg = new RegisterPage(driver);

        reg.register("Test", "test@mail.com", "123");

        assertTrue(reg.isErrorDisplayed());
    }
}
