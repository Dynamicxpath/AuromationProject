package com.Automation;

import com.girijaAutomation.Annotations.FrameworkAnnotation;
import com.girijaAutomation.Enum.CategoryType;
import com.girijaAutomation.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest{

    private AmazonDemoTest(){}
    @FrameworkAnnotation(author = {"Girija","Giru"},category={CategoryType.SMOKETEST,CategoryType.REGRESSIONTEST})
    @Test
    public void amazonTest(Map<String,String> data){
       String title= new AmazonHomePage().clickHamburger().clickMobilesAndComputers().
                         clickOnSubMenuItem(data.get("menuname")).getTitle();
        Assertions.assertThat(title).isNotNull().isNotBlank();
    }

}
