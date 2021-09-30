package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.AppConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTestClass extends BaseTest {
    @TestRails(id="1")
    @Test(testName = "Tests to check if user can login with valid credentials")
    public void validLogin(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        Assert.assertTrue(mainPage.isGoodsListDysplayed());
    }

    @TestRails(id="2")
    @Test(testName = "Tests to check if user can filter from cheap")
    public void checkFromlowFilter() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromLow();
        mainPage.checkFromLowPrices();
    }

    @TestRails(id="3")
    @Test(testName = "Tests to check if user can filter from high")
    public void checkFromHighFilter() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromHigh();
        mainPage.checkFromHighPrices();
    }

    @TestRails(id="4")
    @Test(testName = "Tests to check if user can add product to the cart")
    public void addingProduct(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddButton();
        mainPage.cartQntUpdated();
    }
}
