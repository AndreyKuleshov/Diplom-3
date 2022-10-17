package site.nomoreparties.stellarburgers.loginTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class LoginTest extends LoginBaseClass {

    @Test
    @DisplayName("Login from main page")
    @Description("Логин пользователя с главной страницы")
    public void loginFromMainPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickEnterButton()
                .inputEmail(creds.getEmail())
                .inputPassword(creds.getPassword())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(creds.getName(), name);
    }
    @Test
    @DisplayName("Login from account page")
    @Description("Логин пользователя со страницы личного кабинета")
    public void loginFromAccountPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickAccountLink()
                .inputEmail(creds.getEmail())
                .inputPassword(creds.getPassword())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(creds.getName(), name);
    }
    @Test
    @DisplayName("Login from registration page")
    @Description("Логин пользователя со страницы регистрации")
    public void loginFromRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickAccountLink()
                .registerLinkClick()
                .clickLoginButton()
                .inputEmail(creds.getEmail())
                .inputPassword(creds.getPassword())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(creds.getName(), name);
    }
    @Test
    @DisplayName("Login from password recovery page")
    @Description("Логин пользователя со страницы восстановления пароля")
    public void loginFromRecoverPasswordPage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.clickAccountLink()
                .recoverPasswordLinkClick()
                .enterLinkClick()
                .inputEmail(creds.getEmail())
                .inputPassword(creds.getPassword())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();
        Assert.assertEquals(creds.getName(), name);
    }

}
