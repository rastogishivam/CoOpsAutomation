package com.org.coops.utilities;

import java.lang.reflect.Method;

import com.org.coops.constant.Constant;
import com.org.coops.factory.PlaywrightFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	private static final Logger s_logger = LogManager.getLogger(DataProviderUtils.class);
	@DataProvider(name = "fordUI_Web_TestData", parallel = true)
	public Object[][] fordUI_Web_TestData(Method method, ITestContext context) {
		String sheetName = null;
		if(method.getName().toLowerCase().contains("ford_e2e")) {
			sheetName = "Ford_E2E";
		}
		Object[][] data = null;
		boolean isEnvQA = context.getCurrentXmlTest().getParameter("environment").equals("QA");
		if(isEnvQA) {
			String excelPath = Constant.PROJECT_ROOT_PATH + Constant.FORD_EXCEL_PATH;
			s_logger.info("The Test Data Excel sheet is loaded from path :: " + excelPath);
			data = ExcelUtility.getExcelData(excelPath, sheetName, method.getName());
		}
		return data;
	}

	@DataProvider(name = "eventUI_Web_TestData", parallel = true)
	public Object[][] eventUI_Web_TestData(Method method, ITestContext context) {
		String sheetName = null;
		if(method.getName().toLowerCase().contains("event_e2e")) {
			sheetName = "Event_E2E";
		}
		Object[][] data = null;
		boolean isEnvQA = context.getCurrentXmlTest().getParameter("environment").equals("QA");
		if(isEnvQA) {
			String excelPath = Constant.PROJECT_ROOT_PATH + Constant.EVENT_EXCEL_PATH;
			s_logger.info("The Test Data Excel sheet is loaded from path :: " + excelPath);
			data = ExcelUtility.getExcelData(excelPath, sheetName, method.getName());
		}
		return data;
	}

	@DataProvider(name = "habUI_Web_TestData", parallel = true)
	public Object[][] habUI_Web_TestData(Method method, ITestContext context) {
		String sheetName = null;
		if(method.getName().toLowerCase().contains("hab_e2e")) {
			sheetName = "Hab_E2E";
		}
		Object[][] data = null;
		boolean isEnvQA = context.getCurrentXmlTest().getParameter("environment").equals("QA");
		if(isEnvQA) {
			String excelPath = Constant.PROJECT_ROOT_PATH + Constant.HAB_EXCEL_PATH;
			s_logger.info("The Test Data Excel sheet is loaded from path :: " + excelPath);
			data = ExcelUtility.getExcelData(excelPath, sheetName, method.getName());
		}
		return data;
	}
}
