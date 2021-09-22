package Tests;

import Utils.AppConfig;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeLogin(@Optional("chrome") String browser) {
        BrowserFactory browserDriverFactory = new BrowserFactory(browser);
        driver = browserDriverFactory.createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        driver.get(AppConfig.startUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void shuttingDown() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }
}
