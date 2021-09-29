package Tests;

import Utils.AppConfig;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import testRailSetup.APIException;
import testRailSetup.TestRailManager;

import java.io.IOException;
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

    protected String TestcaseID;

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException, APIException {
        if(result.getStatus()==ITestResult.SUCCESS){
            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");
        } else if (result.getStatus()==ITestResult.FAILURE){
            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_FAILED_STATUS, "The test failed");
        }
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }

}
