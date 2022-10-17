package site.nomoreparties.stellarburgers.goToConstructorTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class GoToConstructorTest extends GoToConstructorBaseClass {
    HomePage homePage = new HomePage(driver);
    @Test
    @DisplayName("Constructor link leads to construstor page")
    @Description("Ссылка 'Конструктор' ведет на страницу конструктора бургера")
    public void constructorLinkClickTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .constructorLinkClick()
                .constructorHeaderIsVisible());
    }
    @Test
    @DisplayName("Main logo link leads to construstor page")
    @Description("Клик по лого в шапке сайта ведет на страницу конструктора бургера")
    public void mainLogoLinkClickTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .mainLogoClick()
                .constructorHeaderIsVisible());
    }
}
