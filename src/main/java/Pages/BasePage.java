package Pages;

import Utils.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBeVisible(WebElement element, int timeOut){
        WebDriverWait configWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        configWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void elementClick(WebElement element) {
        try {
            waitForElementToBeVisible(element, 5);
        } catch (NoSuchElementException n) {
            System.out.print("The element is not visible");
        }
        element.click();
    }
}
