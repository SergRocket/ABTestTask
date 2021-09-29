package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.AppConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test(testName = "Tests to check if user can login with valid credentials")
    public void validLogin(){
        TestcaseID = "1";
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        Assert.assertTrue(mainPage.isGoodsListDysplayed());
    }
}
