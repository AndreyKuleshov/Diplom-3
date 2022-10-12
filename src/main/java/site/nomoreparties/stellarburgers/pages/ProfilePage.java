package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//label[text()='Имя']//following-sibling::input")
    private WebElement nameField;
    @FindBy(xpath = ".//label[text()='Логин']//following-sibling::input")
    private WebElement emailField;
    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement exitButton;
    @FindBy(xpath = ".//a[text()='Профиль']")
    private WebElement profileLink;
    @FindBy(xpath = ".//p[text()='Конструктор']")
    private WebElement constructorLink;
    @FindBy(xpath = ".//a[@href='/']")
    private WebElement mainLogo;

    public String getNameValue() {
        return nameField.getAttribute("value");
    }
    public String getEmailValue() {
        return emailField.getAttribute("value");
    }
    public LoginPage exitButtonClick() {
        //new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(exitButton)).click();
        exitButton.click();
        return new LoginPage(driver);
    }
    public boolean profileLinkIsDisplayed() {
        return profileLink.isDisplayed();
    }
    public HomePage constructorLinkClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(constructorLink)).click();
        return new HomePage(driver);
    }
    public HomePage mainLogoClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainLogo)).click();
        return new HomePage(driver);
    }
}
