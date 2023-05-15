package com.girijaAutomation.factory;

import com.girijaAutomation.Driver.DriverManager;
import com.girijaAutomation.Enum.WaitStrategy;
import org.girijaAutomation.frameworkConstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {

            WebElement element=DriverManager.getDriver().findElement(by);
        }
        return null;
    }
}



