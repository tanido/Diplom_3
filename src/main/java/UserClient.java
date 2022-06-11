import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String BaseUri = "https://stellarburgers.nomoreparties.site/api/auth";

    @Step("Создать пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(BaseUri  + "/register")
                .then();
    }

    @Step("Залогиниться пользователем")
    public ValidatableResponse loginUser(UserCredentials credentials) {
        return given()
                .header("Content-Type", "application/json")
                .body(credentials)
                .when()
                .post(BaseUri  + "/login")
                .then();
    }

    @Step("Удалить пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", accessToken)
                .delete(BaseUri  + "/user")
                .then()
                .assertThat().statusCode(202);
    }
}
