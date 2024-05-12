package com.org.coops.logger;

import com.org.coops.base.BaseTest;
import com.org.coops.report.CoverageReportManager;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;

public class TestLogger extends CoverageReportManager {
	private static final Logger s_logger = LogManager.getLogger(TestLogger.class);
    public static long START_TIME;
    static long END_TIME;
    private static String partner;
    private static String env;
    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();
    public static ExtentReports extent;

    public static void init(ITestContext context){
        setDetails(context);
        setEnv(context);
        extent = CoverageReportManager.getInstance();
    }

    public static synchronized ExtentTest getTest() {
        return extentTestThreadLocal.get();
    }

    public static synchronized void log(String step) {
        s_logger.info(step);
        if(CoverageReportManager.TCR_FLAG) {
            TestLogger.getTest().log(Status.INFO, step);
        }
    }

    public static synchronized void log(boolean status, String step) {
        s_logger.info(step + " :: " + status);
        Status stepStatus;
        String step_status="info";
        if (status) {
            stepStatus = Status.PASS;
            step_status = "pass";
        } else{
            stepStatus = Status.FAIL;
            step_status = "fail";
        }
        if(CoverageReportManager.TCR_FLAG) {
            if(step_status.equalsIgnoreCase("fail")){
                String screenshotPath = BaseTest.captureScreenshot();
                getTest().addScreenCaptureFromPath(screenshotPath);
            }
            TestLogger.getTest().log(stepStatus, step);
        }
    }

    public static synchronized void endTest() {
        END_TIME = System.currentTimeMillis();
        if(CoverageReportManager.TCR_FLAG) {
            extent.flush();
        }
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        String expendedTestName =  testName;
        if(!testName.trim().contains(" ")) expendedTestName = expandTestName(testName);
        String testDescription = "Test Case Description : " + description;
        extentTestThreadLocal.set(extent.createTest(testName, testDescription));
        return extentTestThreadLocal.get();
    }

    private static String expandTestName(String tName){
        String sen = "";
        String[] r = tName.split("(?=\\p{Upper})");
        r[0] = r[0].substring(0, 1).toUpperCase() + r[0].substring(1);
        for(String each: r)
            sen = sen + " " + each;

        return sen.trim();
    }
    
    public static void logStepAndVerify(String step, boolean status) {
    	log(status, step);
    	Assert.assertTrue(status);
    }
    
    public static void logStep(String step) {
    	s_logger.info(step);
    }

    private static void setDetails(ITestContext context){
        partner = context.getCurrentXmlTest().getParameter("partnerName");
    }

    public static String getPartner(){
        return partner;
    }

    private static void setEnv(ITestContext context){
        env = context.getCurrentXmlTest().getParameter("environment");
    }

    public static String getEnv(){
        return env;
    }
}
