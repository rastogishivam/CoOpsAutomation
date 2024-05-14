package com.org.coops.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.microsoft.playwright.Page;

public class BaseWebPage {

    private static final Logger s_logger = LogManager.getLogger(BaseWebPage.class);
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

}
