package com.girijaAutomation.utilities;

public class DynamicXpathUtils {
    public static String getXpath(String xpath,String value){

        //return xpath.replace("%replaceable%",value);
        return String.format(xpath,value);
    }
}
