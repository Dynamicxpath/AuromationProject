package com.girijaAutomation.Listners;

import com.girijaAutomation.Enum.ConfigProperties;
import com.girijaAutomation.utilities.ReadPropertiesFile;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (ReadPropertiesFile.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = count < retries;
            count++;

        }
            return value;


    }
}
