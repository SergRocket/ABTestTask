package Tests;

import Utils.AppConfig;
import Utils.BrowserFactory;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import testRailSetup.APIClient;
import testRailSetup.APIException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private static final String PROJECT_ID = "1";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected APIClient client;
    protected HashMap data;

    public static String TESTRAIL_USERNAME = "serg.lishko1988@gmail.com";
    public static String TESTRAIL_PASSWORD = "fg78N7RS";
    public static String RAILS_ENGINE_URL = "https://sergrocketqaa.testrail.io/";

    @BeforeSuite
    public void createRun(ITestContext ctx) throws IOException, APIException {
        client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        data = new HashMap();
        data.put("include_all", true);
        data.put("name", "Test Run " + System.currentTimeMillis());
        JSONObject c = null;
        c = (JSONObject) client.sendPost("add_run/" + PROJECT_ID, data);
        Long suite_id = (Long) c.get("id");
        ctx.setAttribute("suiteId", suite_id);
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeLogin(@Optional("chrome") String browser) {
        System.out.print(data);
        BrowserFactory browserDriverFactory = new BrowserFactory(browser);
        driver = browserDriverFactory.createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        driver.get(AppConfig.startUrl);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = MainTestClass.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            ctx.setAttribute("caseId", ta.id());
        }
    }

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx) throws IOException, APIException {
        Map data = new HashMap();
        client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        if (result.isSuccess()) {
            data.put("status_id", 1);
        } else {
            data.put("status_id", 5);
            data.put("comment", result.getThrowable().toString());
        }
        String caseId = (String) ctx.getAttribute("caseId");
        Long suiteId = (Long) ctx.getAttribute("suiteId");
        client.sendPost("add_result_for_case/" + suiteId + "/" + caseId, data);
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }
}




