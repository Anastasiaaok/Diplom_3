package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By email = By.xpath("//input[@type='text']");
    private By password = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[text()='Войти']");

    private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By forgotPassword = By.xpath("//a[text()='Восстановить пароль']");

    // ВАЖНО — кнопка "Войти" на странице регистрации
    private By loginFromRegister = By.xpath("//a[text()='Войти']");

    @Step("Ввод email и password и клик Войти")
    public void login(String mail, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Переход на регистрацию")
    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    @Step("Переход на восстановление пароля")
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();
    }

    @Step("Переход обратно на логин со страницы регистрации")
    public void clickLoginFromRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(loginFromRegister)).click();
    }
}