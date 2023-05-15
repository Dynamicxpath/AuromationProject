package com.girijaAutomation.pages;

import com.girijaAutomation.Driver.DriverManager;
import com.girijaAutomation.Enum.WaitStrategy;
import com.girijaAutomation.factory.ExplicitWaitFactory;
import com.girijaAutomation.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementname) {
//        if(waitStrategy== WaitStrategy.CLICKABLE)
//        {
//            ExplicitlyWaitUntilElementToBeClickable(by);
//        } else if (waitStrategy== WaitStrategy.PRESENCE)
//        {
//            ExplicitlyWaitUntilElementToBePresent(by) ;
//        }
//        DriverManager.getDriver().findElement(by).click();
        WebElement Ele = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        Ele.click();
        ExtentLogger.pass(elementname + " is clicked");
    }


    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementname) {

        WebElement Ele = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        Ele.sendKeys(value);
        ExtentLogger.pass(value + "is enetered succesfully in" + elementname);

        try {
            ExtentLogger.pass(value, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}


