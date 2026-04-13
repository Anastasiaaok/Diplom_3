package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest {

    private String email = "test@mail.com";
    private String password = "123456";

    @Test
    @DisplayName("Вход через главную")
    @Description("Проверка входа через кнопку 'Войти в аккаунт'")
    public void loginFromMain() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login(email, password);
    }

    @Test
    @DisplayName("Вход через личный кабинет")
    @Description("Проверка входа через личный кабинет")
    public void loginFromAccount() {
        MainPage main = new MainPage(driver);
        main.clickPersonalAccount();

        LoginPage login = new LoginPage(driver);
        login.login(email, password);
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void loginFromRegister() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.clickRegister();
        login.clickLoginFromRegister();

        login.login(email, password);
    }

    @Test
    @DisplayName("Вход через восстановление пароля")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void loginFromForgotPassword() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.clickForgotPassword();
        login.clickLoginFromRegister();

        login.login(email, password);
    }
}