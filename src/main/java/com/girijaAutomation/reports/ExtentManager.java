package com.girijaAutomation.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager(){

    }
    private  static ThreadLocal<ExtentTest> extTest= new ThreadLocal<>();
    public static ExtentTest getExtent()
    {
        return  extTest.get();
    }
     static void setExtent(ExtentTest test){
        extTest.set(test);
    }
     static void unload()
    {
        extTest.remove();
    }
}

