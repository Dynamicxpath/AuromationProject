package com.girijaAutomation.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.girijaAutomation.frameworkConstants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetname) {
        List<Map<String, String>> list = null;
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelPath())) {
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet Sheet = wb.getSheet(sheetname);
            Map<String, String> map = null;
            list = new ArrayList<>();
            int rownum = Sheet.getLastRowNum();
            int colnum = Sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= rownum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < colnum; j++) {
                    String key = Sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = Sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Excel file you trying to read not found");
        } catch (IOException e) {
            throw new RuntimeException("some io exception happened while reading excel file");
        }
        return list;

    }
}
