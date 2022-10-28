package site.nomoreparties.stellarburgers.registrationTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class RegistrationTest extends RegistrationBaseClass {
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Registration. Success")
    @Description("Успешная регистрация")
    public void successfulRegistrationTest() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(creds.getName())
                .inputEmail(creds.getEmail())
                .inputPassword(creds.getPassword())
                .registerButtonClickSuccess()
                .enterHeadingIsVisible());
    }
    @Test
    @DisplayName("Registration. Fail. Password has 5 symbols")
    @Description("Неуспешная регистрация - пароль 5 символов")
    public void unsuccessfulRegistrationTestPasswordFiveSymbols() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(creds.getName())
                .inputEmail(creds.getEmail())
                .inputPassword(testData.generateRandomLengthString(5))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }
    @Test
    @DisplayName("Registration. Fail. Password has 3 symbols")
    @Description("Неуспешная регистрация - пароль 3 символа")
    public void unsuccessfulRegistrationTestPasswordThreeSymbols() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(creds.getName())
                .inputEmail(creds.getEmail())
                .inputPassword(testData.generateRandomLengthString(3))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }

    @Test
    @DisplayName("Registration. Fail. Password has 1 symbols")
    @Description("Неуспешная регистрация - пароль 1 символ")
    public void unsuccessfulRegistrationTestPasswordOneSymbol() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(creds.getName())
                .inputEmail(creds.getEmail())
                .inputPassword(testData.generateRandomLengthString(1))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }
}
