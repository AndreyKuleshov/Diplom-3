package site.nomoreparties.stellarburgers.constructorTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class ConstructorTest extends ConstructorBaseClass{
    HomePage homePage = new HomePage(driver);
    @Test
    @DisplayName("Constructor check. Bun is active")
    @Description("Проверка конструктора бургера. По умолчанию активна вкладка 'Булочка'")
    public void bunsTest() {
        Assert.assertEquals(testData.getBUNS(), homePage.getCurrentConstructorGroupText());
    }
    @Test
    @DisplayName("Constructor check. Souse is active")
    @Description("Проверка конструктора бургера. При нажатии на вкладку 'Соус', она становится активной")
    public void souseTest() {
        Assert.assertEquals(testData.getSOUSE(), homePage.clickSouseLink().getCurrentConstructorGroupText());
    }
    @Test
    @DisplayName("Constructor check. Filling is active")
    @Description("Проверка конструктора бургера. При нажатии на вкладку 'Начинка', она становится активной")
    public void fillingTest() {
        Assert.assertEquals(testData.getFILLING(), homePage.clickFillingLink().getCurrentConstructorGroupText());
    }
}
