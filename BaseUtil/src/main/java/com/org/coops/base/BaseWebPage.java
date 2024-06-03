package com.org.coops.base;

import com.microsoft.playwright.options.SelectOption;
import com.org.coops.factory.CSRFactory;
import com.org.coops.logger.TestLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.microsoft.playwright.Page;
import org.testng.ITestContext;

import java.time.Duration;

public class BaseWebPage {

    public static final Logger s_logger = LogManager.getLogger(BaseWebPage.class);
	private Page driver;
    private static Logger logger;
    
    public BaseWebPage(Page page) {
    	logger = LogManager.getLogger(BaseWebPage.class);
    	driver = page;
    }

    public String switchToDynamicLocator(String loc, String dynValues){
        String[] val = dynValues.split("~");
        for(int i = 0; i < val.length; i++){
            loc = loc.replace("{" + (i + 1) + "}", val[i]);
        }
        return loc;
    }

    public void wait(int sec){
        Long seconds = (long) sec;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToCSR(){
        CSRFactory.navigateToCSR(driver);
    }
}
