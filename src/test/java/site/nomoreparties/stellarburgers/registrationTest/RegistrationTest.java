package site.nomoreparties.stellarburgers.registrationTest;

import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class RegistrationTest extends RegistrationBaseClass {
    HomePage homePage = new HomePage(driver);

    @Test
    public void successfulRegistrationTest() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL())
                .inputPassword(testData.getPASSWORD())
                .registerButtonClickSuccess()
                .enterHeadingIsVisible());
    }
    @Test
    public void unsuccessfulRegistrationTestPasswordFiveSymbols() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL())
                .inputPassword(testData.generateRandomLengthString(5))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }
    @Test
    public void unsuccessfulRegistrationTestPasswordThreeSymbols() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL())
                .inputPassword(testData.generateRandomLengthString(3))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }

    @Test
    public void unsuccessfulRegistrationTestPasswordOneSymbol() {
        Assert.assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL())
                .inputPassword(testData.generateRandomLengthString(1))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }
}
