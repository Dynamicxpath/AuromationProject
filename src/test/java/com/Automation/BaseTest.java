package com.Automation;

import com.girijaAutomation.Driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest {
    protected BaseTest(){

    }
    @BeforeSuite
    public void beforeSuite()  {
       // ExtentReport.initReports();
    }
    @AfterSuite
    public void afterSuite(){
       // ExtentReport.flushReports();
    }

    @BeforeMethod
    protected void setUP(Object[] data) {
        Map<String,String> map=(Map<String,String>) data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.closeDriver();
    }
}
