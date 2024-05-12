package com.org.coops.utilities;

import com.org.coops.constant.Constant;
import com.org.coops.factory.PlaywrightFactory;
import com.org.coops.logger.TestLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
    public static Properties prop;
    private static final Logger s_logger = LogManager.getLogger(FileUtils.class);
    public static void init(){
        cleanCoverageReport();
        prop = init_prop();
    }
    public static void cleanCoverageReport(){
        File file = new File(Constant.COVERAGE_REPORT_FOLDER_PATH);
        File[] files = file.listFiles();
        if(files.length != 0 || files != null){
            for(File covFile : files){
                covFile.delete();
            }
        }
    }
    private static Properties init_prop(){
        Properties properties = new Properties();
        try {
            s_logger.info("Read the Config File from :: " + Constant.CONFIG_PROP_PATH);
            FileInputStream fileInputStream = new FileInputStream(new File(Constant.CONFIG_PROP_PATH));
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String createDirIfNotExist(String path){
        File testDirectory = new File(path);
        if(!testDirectory.exists()) {
            if(testDirectory.mkdir()) {
                s_logger.info("The Directory is created at path :: " + path);
            }else {
                s_logger.info("The Directory is already created at path :: " + path);
            }
        }
        return path;
    }

    public static String getProject(){
        String project = prop.get("project").toString().toLowerCase();
        switch (project){
            case "auto" : project = "CoOpsAuto";
            break;

            case "event" : project = "CoOpsEvent";
            break;

            case "hab"  :   project = "CoOpsHab";
            break;
        }
       return project;
    }
}
