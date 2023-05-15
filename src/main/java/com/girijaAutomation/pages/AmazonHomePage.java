package com.girijaAutomation.pages;

import com.girijaAutomation.Driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BasePage {

    @FindBy(id="nav-hamburger-menu")
    private WebElement linkHamburgerMenu;

   public AmazonHomePage(){
       PageFactory.initElements(DriverManager.getDriver(),this);
   }

   public AmazonHamburgerMenuPage clickHamburger(){
       linkHamburgerMenu.click();
       return new AmazonHamburgerMenuPage();
   }


}
