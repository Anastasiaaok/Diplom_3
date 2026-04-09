package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через главную")
    @Description("Проверка входа через кнопку 'Войти в аккаунт'")
    public void loginFromMain() {
        MainPage main = new MainPage(driver);
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("test@mail.com", "123456");
    }

    @Test
    @DisplayName("Вход через личный кабинет")
    @Description("Проверка входа через личный кабинет")
    public void loginFromAccount() {
        MainPage main = new MainPage(driver);
        main.clickPersonalAccount();

        LoginPage login = new LoginPage(driver);
        login.login("test@mail.com", "123456");
    }

}
