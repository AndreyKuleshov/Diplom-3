package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
@Data
public class User {
    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    @Step("Create random user")
    public static User createRandomUser() {
        return new User(
                (RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru").toLowerCase(),
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphabetic(10)
        );
    }

}
