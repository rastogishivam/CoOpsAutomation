package com.org.coops.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class CoverageReportManager {

    private static ExtentReports extentReports;
    private static final String reportFileName = "Test-Automation-Coverage-Report" + ".html";
    private static final String reportFilePath = "./target/coverageReport";
    private static final String reportFileLocation = reportFilePath + "/" + reportFileName;
    public static boolean TCR_FLAG = false;
    public static String SUITE_NAME;
    public static String SQUAD_NAME;
    public static String TEST_ENV;

    public static ExtentReports getInstance() {
        if(extentReports == null)
            createSparkReportInstance();
        return extentReports;
    }

    private static ExtentReports createSparkReportInstance(){
        String fileName = getReportPath(reportFilePath);
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Ford Partner UI" + " Report");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Ford Partner UI" + " Report");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setProtocol(Protocol.HTTPS);
        sparkReporter.config().setCss("css-string");
        sparkReporter.config().setJs("js-string");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Test Environment", "QA");
        return extentReports;
    }

    /*public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilePath);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Ford Partner UI" + " Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Ford Partner UI" + " Report");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setCSS("css-string");
        htmlReporter.config().setJS("js-string");

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Test Environment", "QA");
        return extentReports;
    }*/

    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if(!testDirectory.exists()) {
            if(testDirectory.mkdir()) {
                System.out.println("Directory : " + path + " is created.!");
                return reportFileLocation;

            }else {
                System.out.println("Filed to create Directory : " + path);
                return System.getProperty("user.dir");
            }
        }
        return reportFileLocation;
    }
}
