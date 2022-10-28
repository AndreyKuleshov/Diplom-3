package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ".//label[text()='Имя']//following-sibling::input")
    private WebElement nameInput;
    @FindBy(xpath = ".//label[text()='Email']//following-sibling::input")
    private WebElement emailInput;
    @FindBy(xpath = ".//label[text()='Пароль']//following-sibling::input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement registerButton;
    @FindBy(xpath = ".//a[text()='Войти']")
    private WebElement loginButton;
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement incorrectPasswordErrorText;

    @Step("RegisterPage. Input name")
    public RegisterPage inputName(String text) {
        nameInput.sendKeys(text);
        return this;
    }
    @Step("RegisterPage. Input email")
    public RegisterPage inputEmail(String text) {
        emailInput.sendKeys(text);
        return this;
    }
    @Step("RegisterPage. Input password")
    public RegisterPage inputPassword(String text) {
        passwordInput.sendKeys(text);
        return this;
    }
    @Step("RegisterPage. Register button click (login, email, password are correct)")
    public LoginPage registerButtonClickSuccess() {
        registerButton.click();
        return new LoginPage(driver);
    }
    @Step("RegisterPage. Register button click (some data is incorrect)")
    public RegisterPage registerButtonClickFailure() {
        registerButton.click();
        return this;
    }
    @Step("RegisterPage. Password error is visible")
    public boolean passwordErrorIsVisible() {
        return incorrectPasswordErrorText.isDisplayed();
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
