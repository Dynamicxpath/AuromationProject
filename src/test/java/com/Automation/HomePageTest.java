package com.Automation;

import com.girijaAutomation.Driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {
    private HomePageTest(){

    }

        @Test
        public void test3()
        {
            DriverManager.getDriver().findElement(By.name("q")).sendKeys("BJP","Keys.ENTER");
            String title=DriverManager.getDriver().getTitle();
            Assertions.assertThat(title)
                    .as("title is to be null").isNotNull()
                    .containsIgnoringCase("Mini Bytes")
                   // .hasSize(10)
                   // .hasSizeBetween(10,15)
                    ;
        }
    }


