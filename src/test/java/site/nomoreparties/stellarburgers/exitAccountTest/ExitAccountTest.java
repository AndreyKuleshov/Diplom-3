package site.nomoreparties.stellarburgers.exitAccountTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class ExitAccountTest extends ExitAccountBaseClass {
    HomePage homePage = new HomePage(driver);
    @Test
    @DisplayName("Exit account test")
    @Description("Проверка корректного выхода из аккаунта")
    public void exitAccountTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .exitButtonClick()
                .enterButtonIsVisible());
    }
}
