package com.girijaAutomation.pages;

import com.girijaAutomation.Enum.WaitStrategy;
import com.girijaAutomation.reports.ExtentLogger;
import com.girijaAutomation.utilities.DecodeUtils;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {
    private final By textbox_username= By.xpath("//input[@name='username' and @placeholder='Username']");
    private final By textbox_password= By.xpath("//input[@name='password' and @type='password']");
    private final By login_button = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterEmail(String username)  {
        sendKeys(textbox_password,username, WaitStrategy.CLICKABLE,"username");
        return this;
    }
    public OrangeHRMLoginPage enterPassWord(String password)  {
        sendKeys(textbox_password, DecodeUtils.getDecodedString(password), WaitStrategy.CLICKABLE,"password");
        return this;
    }
    public OrangeHRMLoginPage clickLoginButton()  {

        click(login_button,WaitStrategy.PRESENCE,"Login Button");
        ExtentLogger.pass("welcome clicked");

        return new OrangeHRMLoginPage();
    }
    public String getTitle()
    {
        return getPageTitle();
    }
}
