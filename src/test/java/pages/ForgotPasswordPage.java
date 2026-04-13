package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath("//a[text()='Войти']");

    @Step("Клик по кнопке Войти на странице восстановления")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}