package com.girijaAutomation.pages;

import com.girijaAutomation.Enum.WaitStrategy;
import com.girijaAutomation.utilities.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class AmazonHamburgerMenuPage extends BasePage {
//  @FindBy(xpath="//div[text()= 'Mobiles, Computers' ]/parent::a")
//  private WebElement linkMobilesComputers;
  private String linkComputers="//div[text()= 'Mobiles, Computers' ]/parent::a";
    private String linkSubMenu = "//a[text()='%s']";
//
//    @FindBy(xpath = "//a[text()='Laptops']")
//    private WebElement linkLaptop;
//    @FindBy(xpath = "//a[text()='Drives & Storage']")
//    private WebElement linkDriveAndStorage;
//    @FindBy(xpath = "//a[text()='Printers & Ink']")
//    private WebElement linkPrinterAndInk;


    public AmazonHamburgerMenuPage clickMobilesAndComputers() {
        click(By.xpath(linkComputers),WaitStrategy.CLICKABLE,"Mobiles and Computers");
        return this;
    }
    public AmazonLaptopPage clickOnSubMenuItem(String menuText) {
        //String newXpath = linkSubMenu.replace("%replaceable%", menuText);
        String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);
        click(By.xpath(newXpath), WaitStrategy.CLICKABLE,menuText);
        if(menuText.contains("Laptops")){
            return new AmazonLaptopPage();
        }

        return null;
    }
}

//public  AmazonHamburgerMenuPage(){
//    PageFactory.initElements(DriverManager.getDriver(),this);
//}
//public AmazonLaptopPage clickLaptop(){
//    linkLaptop.click();
//    return new AmazonLaptopPage();
//}
//    public AmazonDrivePage clickDriveAndStorage() {
//        linkDriveAndStorage.click();
//        return new AmazonDrivePage();
//    }
//    public AmazonPrinterPage clickPrinter() {
//        linkPrinterAndInk.click();
//        return new AmazonPrinterPage();
//    }
//
//
//}
