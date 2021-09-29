package testRailSetup;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {
    //public static String TEST_RUN_ID                = "1";
    private static String PROJECT_ID                = "1";
    public static String TESTRAIL_USERNAME          = "serg.lishko1988@gmail.com";
    public static String TESTRAIL_PASSWORD          = "fg78N7RS";
    public static String RAILS_ENGINE_URL           = "https://sergrocketqaa.testrail.io/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;



    public static void addResultForTestCase(String testCaseId, int status,
                                            String error) throws IOException, APIException, IOException {
        //String testRunId = TEST_RUN_ID;
        JSONObject c = null;
        Map data = new HashMap();
        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
                Long runId = (Long)c.get("runId");
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
        client.sendPost("add_result_for_case/"+runId+"/"+testCaseId,data );
    }

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("name","Test Run "+System.currentTimeMillis());
        JSONObject c = null;
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
        Long runId = (Long)c.get("runId");
        Long suite_id = (Long)c.get("id");
        ctx.setAttribute("suiteId",suite_id);
        ctx.setAttribute("runId", runId);
    }



}
