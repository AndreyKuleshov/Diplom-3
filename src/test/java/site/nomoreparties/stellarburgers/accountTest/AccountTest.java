package site.nomoreparties.stellarburgers.accountTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class AccountTest extends AccountBaseClass {
    HomePage homePage = new HomePage(driver);
    @Test
    @DisplayName("Logged in user. Account page is displayed")
    @Description("Проверка отображения личного кабинета, если пользователь залогинен")
    public void checkAccountIsDisplayedTest() {
        Assert.assertTrue(homePage.clickAccountLinkAfterLogin()
                .profileLinkIsDisplayed());
    }
    @Test
    @DisplayName("Logged in user. Real Name is displayed")
    @Description("Проверка отображения правильного имени в личном кабинете")
    public void checkNameMatchesRealNameTest() {
        String name = homePage.clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(testData.getNAME_REAL(), name);
    }
    @Test
    @DisplayName("Logged in user. Real Email is displayed")
    @Description("Проверка отображения правильного емейла в личном кабинете")
    public void checkEmailMatchesRealEmailTest() {
        String email = homePage.clickAccountLinkAfterLogin()
                .getEmailValue();
        Assert.assertEquals(testData.getEMAIL_REAL(), email);
    }
}
