package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath("//a[@href='/account']");

    private By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");

    // активные вкладки
    private By bunsActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private By saucesActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private By fillingsActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");

    @Step("Клик по кнопке Войти")
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Клик по Личному кабинету")
    public void clickPersonalAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    @Step("Клик на Булки")
    public void clickBuns() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Клик на Соусы")
    public void clickSauces() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(saucesTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Клик на Начинки")
    public void clickFillings() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isBunsActive() {
        return driver.findElement(bunsActive).isDisplayed();
    }

    public boolean isSaucesActive() {
        return driver.findElement(saucesActive).isDisplayed();
    }

    public boolean isFillingsActive() {
        return driver.findElement(fillingsActive).isDisplayed();
    }
}
