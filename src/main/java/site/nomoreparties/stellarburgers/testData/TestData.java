package site.nomoreparties.stellarburgers.testData;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import site.nomoreparties.stellarburgers.api.ApiClient;
import site.nomoreparties.stellarburgers.api.User;
import site.nomoreparties.stellarburgers.api.UserCredentials;
import site.nomoreparties.stellarburgers.api.UserData;

public class TestData {
    private final String BUNS = "Булки";
    private final String SOUSE = "Соусы";
    private final String FILLING = "Начинки";

    public String generateRandomLengthString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
    public String getBUNS() {
        return BUNS;
    }
    public String getSOUSE() {
        return SOUSE;
    }
    public String getFILLING() {
        return FILLING;
    }

    private ApiClient apiClient = new ApiClient();
    private final User user = User.createRandomUser();
    @Step("Get user credentials")
    public UserCredentials getCreds() {return UserCredentials.getCredentialsFromUser(user);}
    @Step("Register random user")
    public UserData registerRandomUser() {
        return apiClient.createUser(user).extract().body().as(UserData.class);
    }
    @Step("Login user to get Access token if it was created")
    public UserData loginUser(UserCredentials creds) {
        return apiClient.loginUser(creds).extract().body().as(UserData.class);
    }
}
