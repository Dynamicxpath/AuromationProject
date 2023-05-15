package com.girijaAutomation.utilities;

import com.girijaAutomation.Driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUtils {

    private ScreenShotUtils(){

    }
    public static String getBase64Image(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
