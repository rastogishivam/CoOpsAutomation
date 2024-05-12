package com.org.coops.constant;

import com.org.coops.logger.TestLogger;
import com.org.coops.utilities.FileUtils;

public class Constant {
    public static final String PARENT_ROOT_PATH = TestLogger.class.getResource("").getPath().replace("target/classes/com/org/coops/logger/", "");
    public static final String PROJECT_ROOT_PATH = TestLogger.class.getResource("/").getPath().replace("target/test-classes/", "");
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String COVERAGE_REPORT_FOLDER = "target/coverageReport";
    public static final String COVERAGE_REPORT_FOLDER_PATH = PROJECT_ROOT_PATH + COVERAGE_REPORT_FOLDER;
    public static final String FAILED_IMG_PATH = COVERAGE_REPORT_FOLDER_PATH + "/";
    public static final String IMG_DIRECTORY =  FAILED_IMG_PATH;
    public static final String CONFIG_PROP = "src/main/resources/Config/config.properties";
    public static final String FORD_EXCEL_PATH = "src/test/resources/TestData/Ford_UI_QA_TestData.xlsx";
    public static final String EVENT_EXCEL_PATH = "src/test/resources/TestData/Event_UI_QA_TestData.xlsx";
    public static final String HAB_EXCEL_PATH = "src/test/resources/TestData/Hab_UI_QA_TestData.xlsx";
    public static final String CONFIG_PROP_PATH = PARENT_ROOT_PATH + CONFIG_PROP;
}
