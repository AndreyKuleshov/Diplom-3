package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
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
    final String ACTIVE_CLASS = "tab_tab_type_current__2BEPc";


    protected WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get(HOME_PAGE_URL);
    }

    @Step("HomePage. Enter button click")
    public LoginPage clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(enterButton)).click();
        return new LoginPage(driver);
    }
    @Step("HomePage. Account link click")
    public LoginPage clickAccountLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        return new LoginPage(driver);
    }
    @Step("HomePage. Account link click after login")
    public ProfilePage clickAccountLinkAfterLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        return new ProfilePage(driver);
    }
    @Step("HomePage. Place order button is displayed")
    public HomePage placeOrderButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(placeOrderButton));
        return new HomePage(driver);
    }
    @Step("HomePage. Constructor header is visible")
    public boolean constructorHeaderIsVisible() {
        return constructorHeader.isDisplayed();
    }
    @Step("HomePage. Souse link click")
    public HomePage clickSouseLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(souseLink)).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.attributeContains(souseLinkParent, "class", ACTIVE_CLASS));
        return this;
    }
    @Step("HomePage. Filling link click")
    public HomePage clickFillingLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(fillingLink)).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.attributeContains(fillingLinkParent, "class", ACTIVE_CLASS));
        return this;
    }
    @Step("HomePage. Get active constructor tab test")
    public String getCurrentConstructorGroupText() {
        return currentConstructorGroup.getText();
    }
}
