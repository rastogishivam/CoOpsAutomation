package com.org.coops.base;

import com.org.coops.logger.TestLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class BaseWebPage {

	private Page driver;
    private static Logger logger;
    
    public BaseWebPage(Page page) {
    	logger = LogManager.getLogger(BaseWebPage.class);
    	driver = page;
    }
}
