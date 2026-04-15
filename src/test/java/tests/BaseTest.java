package tests;

import api.UserClient;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import model.User;
import utils.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;
    protected UserClient userClient;
    protected User user;
    protected String accessToken;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        // ✅ ВОТ ЭТО КРИТИЧНО
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.education-services.ru/");

        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
        RestAssured.filters(new AllureRestAssured());

        userClient = new UserClient();

        var userData = UserGenerator.generateUser();

        user = new User(
                userData.get("email"),
                userData.get("password"),
                userData.get("name")
        );

        accessToken = userClient.createUser(user)
                .then()
                .extract()
                .path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}