package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через главную")
    public void loginFromMain() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.waitForLoginPage();
        login.login(user.get("email"), user.get("password"));

        main.waitForLoadAfterLogin();
        assertTrue(main.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через личный кабинет")
    public void loginFromAccount() {
        MainPage main = new MainPage(driver);
        main.clickPersonalAccount();

        LoginPage login = new LoginPage(driver);
        login.waitForLoginPage();
        login.login(user.get("email"), user.get("password"));

        main.waitForLoadAfterLogin();
        assertTrue(main.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через регистрацию")
    public void loginFromRegister() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.waitForLoginPage();

        login.clickRegister();
        login.clickLoginFromRegister();

        login.waitForLoginPage(); // 🔥 важно
        login.login(user.get("email"), user.get("password"));

        main.waitForLoadAfterLogin();
        assertTrue(main.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через восстановление пароля")
    public void loginFromForgotPassword() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.waitForLoginPage();

        login.clickForgotPassword();
        login.clickLoginFromRegister();

        login.waitForLoginPage(); // 🔥 важно
        login.login(user.get("email"), user.get("password"));

        main.waitForLoadAfterLogin();
        assertTrue(main.isOrderButtonVisible());
    }
}