package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text()='Войти']")
    private WebElement enterLink;

    public LoginPage enterLinkClick() {
        enterLink.click();
        return new LoginPage(driver);
    }
}
