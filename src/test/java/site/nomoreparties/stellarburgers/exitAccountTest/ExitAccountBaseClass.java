package site.nomoreparties.stellarburgers.exitAccountTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.ApiClient;
import site.nomoreparties.stellarburgers.api.UserCredentials;
import site.nomoreparties.stellarburgers.api.UserData;
import site.nomoreparties.stellarburgers.driverSetup.DriverSetup;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.testData.TestData;

public abstract class ExitAccountBaseClass {
    protected static TestData testData = new TestData();
    static DriverSetup setup = new DriverSetup();
    static WebDriver driver;
    private static final ApiClient API_CLIENT = new ApiClient();
    protected static UserData userData = testData.registerRandomUser();
    protected static UserCredentials creds = testData.getCreds();



    @BeforeClass
    public static void setUp() {
        driver = setup.driverSetUp(driver);
        setup.login(new HomePage(driver), creds.getEmail(), creds.getPassword());
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
        if (userData.isSuccess()) {
            API_CLIENT.deleteUser(userData.getAccessToken());
        }
    }

}
