package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.UserGenerator;

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

        reg.register(
                UserGenerator.generateName(),
                UserGenerator.generateEmail(),
                UserGenerator.generatePassword()
        );
    }

    @Test
    @DisplayName("Ошибка короткого пароля")
    @Description("Проверка ошибки при коротком пароле")
    public void wrongPassword() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.clickRegister();

        RegisterPage reg = new RegisterPage(driver);

        reg.register("Test", "test@mail.com", "123");

        assert reg.isErrorDisplayed();
    }
}
