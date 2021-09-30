package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.AppConfig;

public class ProductAddingTest extends BaseTest {
    @TestRails(id="4")
    //@Test(testName = "Tests to check if user can add product to the cart")
    public void addingProduct(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.validPassword, AppConfig.validUsername);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddButton();
        mainPage.cartQntUpdated();
    }
}
