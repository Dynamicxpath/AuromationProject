package com.girijaAutomation.Driver;

import com.girijaAutomation.Enum.ConfigProperties;
import com.girijaAutomation.Exceptions.BrowserInvocationFailedException;
import com.girijaAutomation.factory.DriverFactory;
import com.girijaAutomation.utilities.ReadPropertiesFile;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver(){}
    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {

            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(ReadPropertiesFile.get(ConfigProperties.URL));

        }
    }
    public static void closeDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
           // driver=null;
            DriverManager.unload();
        }
    }
}
