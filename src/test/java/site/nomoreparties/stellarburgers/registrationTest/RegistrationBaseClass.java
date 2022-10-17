package site.nomoreparties.stellarburgers.registrationTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.ApiClient;
import site.nomoreparties.stellarburgers.api.User;
import site.nomoreparties.stellarburgers.api.UserCredentials;
import site.nomoreparties.stellarburgers.api.UserData;
import site.nomoreparties.stellarburgers.driverSetup.DriverSetup;
import site.nomoreparties.stellarburgers.testData.TestData;

public abstract class RegistrationBaseClass {
    protected static TestData testData = new TestData();
    static DriverSetup setup = new DriverSetup();
    static WebDriver driver;
    private UserData userData;
    private final ApiClient API_CLIENT = new ApiClient();
    protected User user;
    protected UserCredentials creds;

    @BeforeClass
    public static void setUp() {
        driver = setup.driverSetUp(driver);
    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }
    @Before
    public void createUser() {
        user = User.createRandomUser();
        creds = UserCredentials.getCredentialsFromUser(user);
    }
    @After
    public void cleanup() {
        userData = testData.loginUser(creds);
        if (userData.isSuccess()) {
            API_CLIENT.deleteUser(userData.getAccessToken());
        }
    }
}
