package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[name='user-name']")
    private WebElement usernamelnput;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(css = "input[name='login-button']")
    private WebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String password, String username){
        usernamelnput.sendKeys(username);
        passwordInput.sendKeys(password);
        elementClick(loginButton);
        return new MainPage(driver);
    }
}
