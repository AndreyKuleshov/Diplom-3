package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    private WebElement accountLink;
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement enterButton;
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement placeOrderButton;
    @FindBy(xpath = ".//h1[text()='Соберите бургер']")
    private WebElement constructorHeader;
    @FindBy(xpath = ".//span[text()='Булки']")
    private WebElement bunLink;
    @FindBy(xpath = ".//h2[text()='Булки']")
    private WebElement bunHeader;
    @FindBy(xpath = ".//span[text()='Соусы']")
    private WebElement souseLink;
    @FindBy(xpath = ".//div[span[text()='Соусы']]")
    private WebElement souseLinkParent;
    @FindBy(xpath = ".//h2[text()='Соусы']")
    private WebElement souseHeader;
    @FindBy(xpath = ".//span[text()='Начинки']")
    private WebElement fillingLink;
    @FindBy(xpath = ".//div[span[text()='Начинки']]")
    private WebElement fillingLinkParent;
    @FindBy(xpath = ".//h2[text()='Начинки']")
    private WebElement fillingHeader;
    @FindBy(xpath = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span")
    private WebElement currentConstructorGroup;


    protected WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get(HOME_PAGE_URL);
    }

    public LoginPage clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(enterButton)).click();
        return new LoginPage(driver);
    }
    public LoginPage clickAccountLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        return new LoginPage(driver);
    }
    public ProfilePage clickAccountLinkAfterLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        return new ProfilePage(driver);
    }
    public HomePage placeOrderButtonIsDisplayed() {
        placeOrderButton.isDisplayed();
        return new HomePage(driver);
    }
    public boolean constructorHeaderIsVisible() {
        return constructorHeader.isDisplayed();
    }
    public HomePage clickBunLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(bunLink)).click();
        return this;
    }
    public HomePage clickSouseLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(souseLink)).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.attributeContains(souseLinkParent, "class", "tab_tab_type_current__2BEPc"));
        return this;
    }
    public HomePage clickFillingLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(fillingLink)).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.attributeContains(fillingLinkParent, "class", "tab_tab_type_current__2BEPc"));
        return this;
    }
    public boolean bunHeaderIsVisible() {
        return bunHeader.isDisplayed();
    }
    public boolean souseHeaderIsVisible() {
        return souseHeader.isDisplayed();
    }
    public boolean fillingHeaderIsVisible() {
        return fillingHeader.isDisplayed();
    }
    public String getCurrentConstructorGroupText() {
        return currentConstructorGroup.getText();
    }
}
