package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к булкам")
    @Description("Проверка переключения на вкладку 'Булки'")
    public void bunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBuns();
    }

    @Test
    @DisplayName("Переход к соусам")
    @Description("Проверка переключения на вкладку 'Соусы'")
    public void saucesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
    }

    @Test
    @DisplayName("Переход к начинкам")
    @Description("Проверка переключения на вкладку 'Начинки'")
    public void fillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
    }
}