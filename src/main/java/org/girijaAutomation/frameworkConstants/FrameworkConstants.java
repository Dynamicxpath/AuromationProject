package org.girijaAutomation.frameworkConstants;

import com.girijaAutomation.Enum.ConfigProperties;
import com.girijaAutomation.utilities.ReadPropertiesFile;

public final class FrameworkConstants {
    private FrameworkConstants() {}
    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + ("/src/test/resources/resources/chromedriver.exe");
    private static final String GECKODRIVERPATH="C:/Users/lenovo/IdeaProjects/AuromationProject/src/test/resources/resources/geckodriver.exe";
    private static final String CONFIGFILEPATH = "C:/Users/lenovo/IdeaProjects/AuromationProject/src/test/resources/Config/config.properties";
    private static final int EXPLICITWAIT = 10;
    private static  String EXCELPATH="C:/Users/lenovo/IdeaProjects/AuromationProject/src/test/resources/excel/TestData.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = "C:/Users/lenovo/IdeaProjects/AuromationProject/extent-test-output/Spark.html/";
    private static String extentReportFilePath= "";
    private static  final String RUNMANAGERSHEET="RunManager";

    private static final String ITERATIONDATASHEET="DATA";

    public static String getRunManagerSheet() {
        return RUNMANAGERSHEET;
    }

    public static String getIterationSheet() {
        return ITERATIONDATASHEET;
    }


    public static String getExtentReportFilePath()  {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath= createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath()  {
        if(ReadPropertiesFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
        {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/Spark.html";
        }
        else{
            return EXTENTREPORTFOLDERPATH + "/Spark.html";
        }
    }
    public static String getExcelPath() {
        return EXCELPATH;
    }


    public static int getExplicitWait() {
            return EXPLICITWAIT;
        }

        public static String getConfigFilePath() {
            return CONFIGFILEPATH;
        }
        public static String getChromeDriverPath() {
            return CHROMEDRIVERPATH;


        }

    public static String getGeckoDriverPth() {
        return GECKODRIVERPATH;
    }
}

