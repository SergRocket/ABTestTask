package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.AppConfig;
import org.testng.annotations.Test;
public class FiltersTest extends BaseTest {
    @Test(testName = "Tests to check if user can filter from cheap")
    public void checkFromlowFilter() {
        TestcaseID = "2";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromLow();
        mainPage.checkFromLowPrices();
    }

    @Test(testName = "Tests to check if user can filter from high")
    public void checkFromHighFilter() {
        TestcaseID = "3";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromHigh();
        mainPage.checkFromHighPrices();
    }
}
