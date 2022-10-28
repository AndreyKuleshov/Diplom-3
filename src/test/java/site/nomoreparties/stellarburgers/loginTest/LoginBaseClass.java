package site.nomoreparties.stellarburgers.loginTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.ApiClient;
import site.nomoreparties.stellarburgers.api.UserCredentials;
import site.nomoreparties.stellarburgers.api.UserData;
import site.nomoreparties.stellarburgers.driverSetup.DriverSetup;
import site.nomoreparties.stellarburgers.testData.TestData;

public abstract class LoginBaseClass {
    protected static TestData testData = new TestData();
    DriverSetup setup = new DriverSetup();
    static WebDriver driver;
    private static final ApiClient API_CLIENT = new ApiClient();
    protected static UserData userData = testData.registerRandomUser();
    protected static UserCredentials creds = testData.getCreds();
    @Before
    public void setUp(){
        driver = setup.driverSetUp(driver);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @AfterClass
    public static void cleanUp() {
        if (userData.isSuccess()) {
            API_CLIENT.deleteUser(userData.getAccessToken());
        }
    }
}
