package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    public Response createUser(String email, String password, String name) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"name\":\"" + name + "\"}")
                .post(BASE_URL + "/api/auth/register");
    }

    public Response deleteUser(String accessToken) {
        return RestAssured.given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/api/auth/user");
    }
}