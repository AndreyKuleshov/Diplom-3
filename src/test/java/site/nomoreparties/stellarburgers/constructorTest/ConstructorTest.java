package site.nomoreparties.stellarburgers.constructorTest;

import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class ConstructorTest extends ConstructorBaseClass{
    HomePage homePage = new HomePage(driver);
    @Test
    public void bunsTest() {
        Assert.assertEquals(testData.getBUNS(), homePage.getCurrentConstructorGroupText());
    }
    @Test
    public void souseTest() {
        Assert.assertEquals(testData.getSOUSE(), homePage.clickSouseLink().getCurrentConstructorGroupText());
    }
    @Test
    public void fillingTest() {
        Assert.assertEquals(testData.getFILLING(), homePage.clickFillingLink().getCurrentConstructorGroupText());
    }
}
