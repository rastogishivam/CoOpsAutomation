package com.org.coops.logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.org.coops.report.CoverageReportManager;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger extends CoverageReportManager {
	private static final Logger s_logger = LogManager.getLogger(TestLogger.class);
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentTest test;
    static Map<String, List<String>> coverageTestMap = Collections.synchronizedMap(new LinkedHashMap<>());
    static HashMap<String, String> methodVsTestNameMap = new HashMap<>();
    static Set<String> ignoreTestKeys = new HashSet<>();
    static String lastTestCase = "";
    public static long START_TIME;
    static long END_TIME;

    static ExtentReports extent = CoverageReportManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return test;
    }

    public static synchronized void log(String step) {
        s_logger.info(step);
        if(CoverageReportManager.TCR_FLAG) {
//            String threadId = String.valueOf((int) Thread.currentThread().getId());
//            coverageTestMap.get(getTest().getModel().getStartTime().hashCode() + "#" + getTest().getModel().getHierarchicalName()+"-"+getTest().getModel().getID() + "#" + threadId).add(step+"#info");
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
            String threadId = String.valueOf((int) Thread.currentThread().getId());
//            coverageTestMap.get(getTest().getModel().getStartTime().hashCode() + "#" + getTest().getModel().getHierarchicalName()+"-"+getTest().getModel().getID() + "#" + threadId).add(step+"#"+step_status);
            TestLogger.getTest().log(stepStatus, step);
        }
    }

    public static synchronized void endTest() {
        END_TIME = System.currentTimeMillis();
        if(CoverageReportManager.TCR_FLAG) {
//            createCoverageReport();
            /*createTabularCoverageReport();
            sendHtmlCoverageEmail();*/
        }
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        String expendedTestName =  testName;
        if(!testName.trim().contains(" ")) expendedTestName = expandTestName(testName);
        String testDescription = "Test Case Description : " + description;
        test = extent.createTest(testName, testDescription);
        return test;
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
    
    public static void logTestCase(String step) {
    	System.out.println("*********************************************************\n");
    	s_logger.info("Started the Test Case ::::  " + step);
    	System.out.println("");
    }
}
