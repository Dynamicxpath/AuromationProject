package com.girijaAutomation.utilities;

import org.girijaAutomation.frameworkConstants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private DataProviderUtils() {}

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(name = "TestDATA")
    public static Object[][] getData(Method method) {
        String testName = method.getName();

        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationSheet());
        }

        List<Map<String, String>> smallList = new ArrayList<>();
        for (Map<String, String> data : list) {
            if (data.get("testname").equalsIgnoreCase(testName) &&
                    data.get("execute").equalsIgnoreCase("yes")) {
                smallList.add(data);
            }
        }

        Object[][] testDataArray = new Object[smallList.size()][1];
        for (int i = 0; i < smallList.size(); i++) {
            testDataArray[i][0] = smallList.get(i);
        }

        return testDataArray;
    }
}
