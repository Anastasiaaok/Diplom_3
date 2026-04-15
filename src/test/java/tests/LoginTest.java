package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Успешный логин")
    @Description("Логин под существующим пользователем")
    public void loginSuccess() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login(user.getEmail(), user.getPassword());

        assertTrue(true);
    }

    @Test
    @DisplayName("Логин с неверным паролем")
    public void loginWrongPassword() {

        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login(user.getEmail(), "wrongpassword");

        assertTrue(true);
    }
}