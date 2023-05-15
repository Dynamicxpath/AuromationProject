package com.Automation;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderWithExcel {
    @Test(dataProvider = "getData")
    public void test(Map<Object,Object> map) {
        System.out.println(map.get("Lname"));
        System.out.println(map.get("Fname"));
        System.out.println(map.get("username"));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
       // File file = new File(".\\resources\\Books1.xlsx");
        //String path = file.getAbsolutePath();
        //System.out.println(path);
        FileInputStream fis = new FileInputStream("/C:/Users/lenovo/Desktop/Book1.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Family");
        int rownum = sheet.getLastRowNum();
        int columnnum = sheet.getRow(0).getLastCellNum();
        Object[][] obj= new Object[rownum][1];
        Map<String,String> map;
        for (int i= 0;i<rownum;i++) {
            map= new HashMap<>();
            for (int j = 0; j < columnnum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                obj[i][0] = map;
            }
        }
        return obj;
            }
        }



