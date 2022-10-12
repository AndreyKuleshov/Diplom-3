package site.nomoreparties.stellarburgers.loginTest;

import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class LoginTest extends LoginBaseClass {

    @Test
    public void loginFromMainPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickEnterButton()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(testData.getNAME_REAL(), name);
    }
    @Test
    public void loginFromAccountPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickAccountLink()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(testData.getNAME_REAL(), name);
    }
    @Test
    public void loginFromRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickAccountLink()
                .registerLinkClick()
                .clickLoginButton()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(testData.getNAME_REAL(), name);
    }
    @Test
    public void loginFromRecoverPasswordPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickAccountLink()
                .recoverPasswordLinkClick()
                .enterLinkClick()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(testData.getNAME_REAL(), name);
    }

}
