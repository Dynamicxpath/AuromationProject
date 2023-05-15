/**
 * Author : lenovo
 * Date : 13-05-2023
 * Time : 06:23 pm
 * Project Nmae : AuromationProject
 * Year : 2023
 */
package com.girijaAutomation.factory;

import com.girijaAutomation.Enum.ConfigProperties;
import com.girijaAutomation.utilities.ReadPropertiesFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {


        AbstractDriverOptions options = null;
        WebDriver driver = null;

        String runmode = ReadPropertiesFile.get(ConfigProperties.RUNMODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                options = new ChromeOptions();
                options.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } else {
                //System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                options = new FirefoxOptions();
                options.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            }
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}





