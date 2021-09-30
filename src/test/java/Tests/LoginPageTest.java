package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.AppConfig;
import org.testng.Assert;

public class LoginPageTest extends BaseTest {
    @TestRails(id="1")
   // @Test(testName = "Tests to check if user can login with valid credentials")
    public void validLogin(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        Assert.assertTrue(mainPage.isGoodsListDysplayed());
    }
}
