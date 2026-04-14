package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.UserGenerator;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации пользователя")
    public void successRegister() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.clickRegister();

        RegisterPage reg = new RegisterPage(driver);

        Map<String, String> user = UserGenerator.generateUser();

        reg.register(
                user.get("name"),
                user.get("email"),
                user.get("password")
        );

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
