package com.girijaAutomation.Listners;

import com.girijaAutomation.Annotations.FrameworkAnnotation;
import com.girijaAutomation.reports.ExtentLogger;
import com.girijaAutomation.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass  implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        //ISuiteListener.super.onStart(suite);
            ExtentReport.initReports();

    }

    @Override
    public void onFinish(ISuite suite) {
       //ISuiteListener.super.onFinish(suite);
           ExtentReport.flushReports();

    }

    @Override
    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestStart(result);
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());


    }

    @Override
    public void onTestSuccess(ITestResult result) {
       // ITestListener.super.onTestSuccess(result);
        ExtentLogger.pass(result.getMethod().getMethodName() +"is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() +" is failed",true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ITestListener.super.onTestSkipped(result);
        ExtentLogger.skip(result.getMethod().getMethodName() +"is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
