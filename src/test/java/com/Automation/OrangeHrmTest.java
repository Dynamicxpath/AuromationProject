package com.Automation;

import com.girijaAutomation.pages.OrangeHRMLoginPage;
import com.girijaAutomation.reports.ExtentReport;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHrmTest extends BaseTest {
    private OrangeHrmTest() {

    }

    @Test(dataProvider = "getDATA")
    public void loginLogoutTest(Map<String,String> data) throws InterruptedException {
        ExtentReport.createTest("LoginLogoutTest");
        OrangeHRMLoginPage olp = new OrangeHRMLoginPage();
        String title = olp.enterEmail(data.get("username")).enterPassWord(data.get("password")).clickLoginButton().getTitle();
        Assertions.assertThat(title)
                .as("Doesnt contain message").isEqualTo("OrangeHRM");

    }

    @Test(dataProvider = "getDATA")
    public void newTest(Map<String,String> data) throws InterruptedException {
        ExtentReport.createTest("LoginLogoutTest");
        OrangeHRMLoginPage olp = new OrangeHRMLoginPage();
        String title = olp.enterEmail(data.get("username")).enterPassWord(data.get("password")).clickLoginButton().getTitle();
        Assertions.assertThat(title)
                .as("Doesnt contain message").isEqualTo("OrangeHRM");

    }
}

//    @DataProvider
//    public Object[][] getDATA() {
//        return new Object[][]{
//                {"Admin","admin123"},
//                {"admin123","Admin"}









