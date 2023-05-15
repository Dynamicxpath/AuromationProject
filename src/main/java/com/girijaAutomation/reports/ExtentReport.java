package com.girijaAutomation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.girijaAutomation.Enum.CategoryType;
import org.girijaAutomation.frameworkConstants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void initReports()  {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Hrm Report");
            spark.config().setReportName("Integration Testing");
        }
    }

    public static void flushReports()  {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createTest(String testcasename) {
        ExtentTest test = extent.createTest(testcasename);
        ExtentManager.setExtent(test);
    }

    public static void addAuthors(String[] authors) {
        for (String temp : authors) {
            ExtentManager.getExtent().assignAuthor(temp);

        }
    }
        public static void addCategories(CategoryType[] categories){
            for (CategoryType temp1:categories) {
                ExtentManager.getExtent().assignCategory(temp1.toString());

            }
            }
        }



