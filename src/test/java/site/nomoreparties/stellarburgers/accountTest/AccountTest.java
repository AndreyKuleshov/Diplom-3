package site.nomoreparties.stellarburgers.accountTest;

import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class AccountTest extends AccountBaseClass {
    HomePage homePage = new HomePage(driver);
    @Test
    public void checkAccountIsDisplayedTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .profileLinkIsDisplayed());
    }
    @Test
    public void checkNameMatchesRealNameTest() {
        String name = homePage.clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(testData.getNAME_REAL(), name);
    }
    @Test
    public void checkEmailMatchesRealEmailTest() {
        String email = homePage.clickAccountLinkAfterLogin()
                .getEmailValue();
        Assert.assertEquals(testData.getEMAIL_REAL(), email);
    }
}
