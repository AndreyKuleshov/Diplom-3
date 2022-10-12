package site.nomoreparties.stellarburgers.exitAccountTest;

import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class ExitAccountTest extends ExitAccountBaseClass {
    HomePage homePage = new HomePage(driver);
    @Test
    public void exitAccountTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .exitButtonClick()
                .enterButtonIsVisible());
    }
}
