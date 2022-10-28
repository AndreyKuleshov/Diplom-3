package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {
    protected static final String USER_ENDPOINT = "auth/user";
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";
    protected static final String AUTHORIZATION_HEADER = "Authorization";
    protected static final String CREATE = "auth/register";
    protected final String LOGIN = "auth/login";

    private static RequestSpecification getSpec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }
    private static RequestSpecification getSpec(String token) {
        return given()
                .contentType(ContentType.JSON)
                .header(AUTHORIZATION_HEADER, token)
                .baseUri(BASE_URL);
    }
    @Step("Create user")
    public ValidatableResponse createUser(User user) {
        return getSpec()
                .body(user)
                .post(CREATE)
                .then();
    }
    @Step("Delete user")
    public void deleteUser(String token) {
        getSpec(token).delete(USER_ENDPOINT);
    }
    @Step("Login user")
    public ValidatableResponse loginUser(UserCredentials creds) {
        return getSpec()
                .body(creds)
                .post(LOGIN)
                .then();
    }
}
