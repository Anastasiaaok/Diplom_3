package pages;

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

    private By bunsTab = By.xpath("//span[text()='Булки']");
    private By saucesTab = By.xpath("//span[text()='Соусы']");
    private By fillingsTab = By.xpath("//span[text()='Начинки']");

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickPersonalAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    public void clickBuns() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void clickSauces() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(saucesTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void clickFillings() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }
}
