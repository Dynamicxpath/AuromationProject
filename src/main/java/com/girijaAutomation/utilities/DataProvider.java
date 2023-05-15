package com.girijaAutomation.utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProvider {
    public static Object[] getData(Method method){
        String test_name=method.getName();
        List<Map<String, String>> list = ExcelUtils.getTestDetails("DATA");
        List<Map<String, String>> small_list= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).get("testname").equalsIgnoreCase(test_name)){
                if(list.get(i).get("execute").equalsIgnoreCase("yes")){
                    small_list.add(list.get(i));
                }
            }

        }














        return small_list.toArray();
    }

}
