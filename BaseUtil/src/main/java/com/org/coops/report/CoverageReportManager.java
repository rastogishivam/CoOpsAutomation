package com.org.coops.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.org.coops.constant.Constant;
import com.org.coops.factory.PlaywrightFactory;
import com.org.coops.logger.TestLogger;
import com.org.coops.utilities.DateUtils;
import com.org.coops.utilities.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CoverageReportManager {

    private static final Logger s_logger = LogManager.getLogger(CoverageReportManager.class);
    private static ExtentReports extentReports;
    private static final String reportFileName = "Test-Report" + DateUtils.getCurrentDateWithTime() + ".html";
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
        String fileName = getReportPath(FileUtils.decodePath(Constant.COVERAGE_REPORT_FOLDER_PATH));
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setReportName("Co-Ops Automation Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Co-Ops Partner UI" + " Report");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Co-Ops Partner UI" + " Report");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setProtocol(Protocol.HTTPS);
        sparkReporter.config().setCss("css-string");
        sparkReporter.config().setJs("js-string");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Test Environment", TestLogger.getEnv());
        extentReports.setSystemInfo("Partner Name", TestLogger.getPartner());
        return extentReports;
    }
    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if(!testDirectory.exists()) {
            if(testDirectory.mkdir()) {
                s_logger.info("The Directory is created at path :: " + path);
                return reportFileLocation;
            }else {
                s_logger.info("The Directory is already created at path :: " + path);
                return System.getProperty("user.dir");
            }
        }
        return reportFileLocation;
    }
}
