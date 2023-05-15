package com.girijaAutomation.Listners;

import com.girijaAutomation.utilities.ExcelUtils;
import org.girijaAutomation.frameworkConstants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {

        List<Map<String, String>> list1 = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());
List<IMethodInstance> result= new ArrayList<>();
        for(int i=0;i<methods.size();i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list1.get(j).get("testname")) &&
                    list1.get(j).get("execute").equalsIgnoreCase("yes")) {
                        methods.get(i).getMethod().setDescription(list1.get(j).get("testdescription"));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list1.get(j).get("count")));
                        result.add(methods.get(i));
                    }
                }
            }

        return result;
    }
}
