package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.AppConfig;
import org.testng.annotations.Test;

public class ProductAddingTest extends BaseTest {
    @Test(testName = "Tests to check if user can add product to the cart")
    public void addingProduct(){
        TestcaseID = "4";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddButton();
        mainPage.cartQntUpdated();
    }
}
