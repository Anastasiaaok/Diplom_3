package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ✅ НАДЁЖНЫЕ локаторы
    private By email = By.xpath("//input[contains(@class,'text_type_main-default')]");
    private By password = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[contains(@class,'button_button_type_primary')]");

    private By registerLink = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private By forgotPassword = By.xpath("//a[contains(text(),'Восстановить пароль')]");
    private By loginFromRegister = By.xpath("//a[@href='/login']");

    @Step("Ожидание страницы логина")
    public void waitForLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
    }

    @Step("Логин")
    public void login(String mail, String pass) {

        // ждём поле email
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailInput.clear();
        emailInput.sendKeys(mail);
        System.out.println("Email введен");

        // 🔥 ЖДЁМ ИМЕННО type=password (самый стабильный вариант)
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        System.out.println("Пароль введен");

        // кнопка входа
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        // иногда обычный click не работает → оставляем JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        System.out.println("Клик по кнопке выполнен");
    }

    @Step("Переход на регистрацию")
    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    @Step("Переход на восстановление пароля")
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();
    }

    @Step("Переход обратно на логин")
    public void clickLoginFromRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(loginFromRegister)).click();
    }
}