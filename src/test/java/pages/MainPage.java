package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // 🔐 Авторизация
    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    private By orderButton = By.xpath("//button[contains(text(),'Оформить заказ')]");
    private By overlay = By.className("Modal_modal_overlay__x2ZCr");

    // 🍔 Конструктор
    private By bunsTab = By.xpath("//span[text()='Булки']");
    private By saucesTab = By.xpath("//span[text()='Соусы']");
    private By fillingsTab = By.xpath("//span[text()='Начинки']");

    private By bunsActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private By saucesActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private By fillingsActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");



    @Step("Клик Войти")
    public void clickLogin() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    @Step("Клик Личный кабинет")
    public void clickPersonalAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccount)).click();
    }
    @Step("Ожидание загрузки после логина")
    public void waitForLoadAfterLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
    @Step("Проверка кнопки Оформить заказ")
    public boolean isOrderButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton)).isDisplayed();
    }



    @Step("Клик Булки")
    public void clickBuns() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Клик Соусы")
    public void clickSauces() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(saucesTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Клик Начинки")
    public void clickFillings() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Булки активны")
    public boolean isBunsActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bunsActive)).isDisplayed();
    }

    @Step("Соусы активны")
    public boolean isSaucesActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(saucesActive)).isDisplayed();
    }

    @Step("Начинки активны")
    public boolean isFillingsActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsActive)).isDisplayed();
    }
}