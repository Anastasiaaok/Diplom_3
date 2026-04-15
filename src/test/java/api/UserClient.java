package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;

public class UserClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    @Step("Создание пользователя")
    public Response createUser(User user) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body(user) // ✅ сериализация
                .post(BASE_URL + "/api/auth/register");
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken) {
        return RestAssured.given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/api/auth/user");
    }
}