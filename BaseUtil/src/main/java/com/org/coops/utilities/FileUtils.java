package com.org.coops.utilities;

import com.org.coops.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class FileUtils {
    public static Properties prop;
    private static final Logger s_logger = LogManager.getLogger(FileUtils.class);
    public static void init(){
        cleanCoverageReport();
//        prop = init_prop();
    }
    public static void cleanCoverageReport(){
        String coverageReport = decodePath(Constant.COVERAGE_REPORT_FOLDER_PATH);
        File file = new File(coverageReport);
        File[] files = file.listFiles();
        if(files != null){
            s_logger.info("Cleaning the Coverage Report from path :: " + coverageReport);
            for(File covFile : files){
                covFile.delete();
            }
        }
    }
    private static Properties init_prop(){
        Properties properties = new Properties();
        try {
            String configFile = decodePath(Constant.CONFIG_PROP_PATH);
            s_logger.info("Read the Config File from :: " + configFile);
            FileInputStream fileInputStream = new FileInputStream(configFile);
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

    public static String decodePath(String path){
        String decodedPath = path;
        try {
            decodedPath = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            s_logger.error(e.getStackTrace());
            throw new RuntimeException(e);
        }
        return decodedPath;
    }
}
