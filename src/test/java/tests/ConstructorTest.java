package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к булкам")
    @Description("Проверка переключения на вкладку 'Булки'")
    public void bunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBuns();
        assertTrue(mainPage.isBunsActive());
    }

    @Test
    @DisplayName("Переход к соусам")
    @Description("Проверка переключения на вкладку 'Соусы'")
    public void saucesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
        assertTrue(mainPage.isSaucesActive());
    }

    @Test
    @DisplayName("Переход к начинкам")
    @Description("Проверка переключения на вкладку 'Начинки'")
    public void fillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
        assertTrue(mainPage.isFillingsActive());
    }
}