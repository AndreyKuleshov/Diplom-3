package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text()='Зарегистрироваться']")
    private WebElement registerLink;
    @FindBy(xpath = ".//h2[text()='Вход']")
    private WebElement enterHeading;
    @FindBy(xpath = ".//label[text()='Email']//following-sibling::input")
    private WebElement emailInput;
    @FindBy(xpath = ".//label[text()='Пароль']//following-sibling::input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement enterButton;
    @FindBy(xpath = ".//a[text()='Восстановить пароль']")
    private WebElement recoverPasswordLink;


    @Step("LoginPage. Register link click")
    public RegisterPage registerLinkClick() {
        registerLink.click();
        return new RegisterPage(driver);
    }
    @Step("LoginPage. Enter header is nisible")
    public boolean enterHeadingIsVisible() {
        return enterHeading.isDisplayed();
    }
    @Step("LoginPage. Input email")
    public LoginPage inputEmail(String text) {
        emailInput.sendKeys(text);
        return this;
    }
    @Step("LoginPage. Input password")
    public LoginPage inputPassword(String text) {
        passwordInput.sendKeys(text);
//        passwordInput.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("LoginPage. Enter button click")
    public HomePage enterButtonClick() {
        enterButton.click();
        return new HomePage(driver).placeOrderButtonIsDisplayed();
    }
    @Step("LoginPage. Enter button is visible")
    public boolean enterButtonIsVisible() {
        enterButton.click();
        return enterButton.isDisplayed();
    }
    @Step("LoginPage. Recover password link click")
    public ForgotPasswordPage recoverPasswordLinkClick() {
        recoverPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }
}
