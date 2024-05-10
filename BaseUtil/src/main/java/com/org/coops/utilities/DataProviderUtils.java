package com.org.coops.utilities;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	@DataProvider(name = "Ford_UI", parallel = true)
	public Object[][] webTestData(Method method, ITestContext context) {
		String sheetName = null;
		if(method.getName().toLowerCase().contains("welcome")) {
			sheetName = "Welcome";
		}else if(method.getName().toLowerCase().contains("aboutyourhome")) {
			sheetName = "AboutYourHome";
		}else if(method.getName().toLowerCase().contains("ford_e2e")) {
			sheetName = "Ford_E2E";
		}
		Object[][] data = null;
		boolean isEnvQA = context.getCurrentXmlTest().getParameter("environment").equals("QA");
		if(isEnvQA) {
			String filePath = "./src/test/resources/TestData/Ford_UI_QA_TestData.xlsx";
			data = ExcelUtility.getExcelData(filePath, sheetName, method.getName());
		}
		return data;
	}
}
