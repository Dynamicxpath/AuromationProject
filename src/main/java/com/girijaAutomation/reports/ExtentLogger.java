package com.girijaAutomation.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.girijaAutomation.Enum.ConfigProperties;
import com.girijaAutomation.utilities.ReadPropertiesFile;
import com.girijaAutomation.utilities.ScreenShotUtils;

public final class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtent().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtent().pass(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtent().pass(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded)  {
        if(ReadPropertiesFile.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                    && isScreenshotNeeded) {
            ExtentManager.getExtent().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

        }
        else{
            pass(message);
        }
    }
    public static void fail(String message, boolean isScreenshotNeeded)  {
        if (ReadPropertiesFile.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtent().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        }
        else{
            fail(message);
        }
    }
    public static void skip(String message, boolean isScreenshotNeeded)  {
        if (ReadPropertiesFile.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtent().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        }
        else{
            skip(message);
        }

    }
}