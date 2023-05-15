package com.Automation;

import com.girijaAutomation.Driver.Driver;
import com.girijaAutomation.Driver.DriverManager;
import org.girijaAutomation.frameworkConstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public  final class Browserinitiation extends BaseTest{
    private Browserinitiation(){

        }

    @Test
    public void test1()
    {
       // Driver.driver.findElement(By.name("q")).sendKeys("Testing Mini Bytes","Keys.ENTER");
       // Driver.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes","Keys.ENTER");
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes","Keys.ENTER");
    }


    @Test
    public void test2()
    {
        //Driver.driver.findElement(By.name("q")).sendKeys("BJP","Keys.ENTER");
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes","Keys.ENTER");
    }
}
