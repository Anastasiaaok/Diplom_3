package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By name = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By email = By.xpath("//label[text()='Email']/following-sibling::input");
    private By password = By.xpath("//input[@type='password']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By error = By.xpath("//p[contains(text(),'Некорректный пароль')]");

    @Step("Регистрация пользователя")
    public void register(String n, String e, String p) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(n);
        driver.findElement(email).sendKeys(e);
        driver.findElement(password).sendKeys(p);
        driver.findElement(registerButton).click();
    }

    @Step("Проверка ошибки пароля")
    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).isDisplayed();
    }
}
