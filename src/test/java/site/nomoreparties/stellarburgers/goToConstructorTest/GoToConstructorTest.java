package site.nomoreparties.stellarburgers.goToConstructorTest;

import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class GoToConstructorTest extends goToConstructorBaseClass {
    HomePage homePage = new HomePage(driver);
    @Test
    public void constructorLinkClickTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .constructorLinkClick()
                .constructorHeaderIsVisible());
    }
    @Test
    public void mainLogoLinkClickTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .mainLogoClick()
                .constructorHeaderIsVisible());
    }
}
