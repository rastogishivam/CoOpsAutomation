package com.org.coops.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.org.coops.base.BaseTest;
import com.org.coops.factory.PlaywrightFactory;
import com.org.coops.logger.TestLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CoverageReportListner implements ITestListener {

    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println("\n*********************************************************\n");
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        if(CoverageReportManager.TCR_FLAG  && null != TestLogger.getTest())
            TestLogger.getTest().log(Status.PASS, "Test passed");
    }

    public synchronized void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        if(CoverageReportManager.TCR_FLAG && null != TestLogger.getTest()) {
            TestLogger.getTest().log(Status.FAIL, "Test Failed");
            String screenshotPath = PlaywrightFactory.captureScreenshot();
            TestLogger.getTest().addScreenCaptureFromPath(screenshotPath);
        }
    }

    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        if(CoverageReportManager.TCR_FLAG  && null != TestLogger.getTest()) {
            TestLogger.getTest().log(Status.SKIP, "Test Skipped");
        }
    }
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    public synchronized void onStart(ITestContext context) {
        TestLogger.START_TIME = System.currentTimeMillis();
        CoverageReportManager.SUITE_NAME = context.getSuite().getName();
        CoverageReportManager.SQUAD_NAME = "Auto_QA";
        CoverageReportManager.TEST_ENV = context.getCurrentXmlTest().getParameter("environment");
        if(context.getCurrentXmlTest().getParameter("tcrReport").equalsIgnoreCase("true"))
            CoverageReportManager.TCR_FLAG = true;
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public synchronized void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        if(CoverageReportManager.TCR_FLAG) {
            TestLogger.endTest();
            CoverageReportManager.getInstance().flush();
        }
    }

    public synchronized void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        System.out.println("*********************************************************\n");
        System.out.println("Started the Test Case ::::  " + result.getMethod().getDescription());
        System.out.println("");
        if(CoverageReportManager.TCR_FLAG)
            TestLogger.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }
}
