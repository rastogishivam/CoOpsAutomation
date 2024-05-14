package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;


public class EventHosting {

	//private static final Logger logger = LogManager.getLogger(EventHosting.class);
    private Page driver;
    private String pageHeader = "//h1[text()='How many events are you hosting?']";
    private String nextButton = "button#btnNextSingleMultiple";
    private String eventHostingSingle = "//label[@for='eventSingleOrMultiple-singleEvent']";
    private String eventHostingMultiple = "//label[@for='eventSingleOrMultiple-multipleEvent']";

    public EventHosting(Page page){
    	driver = page;
    }
    
    public EventHosting isEventHostingPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **How many events are you hosting? ** visible", isVisible);
    	return this;
    }
    
    public EventHosting selectEventHosting(String eventHostingType)  {
    	TestLogger.log("Select your event :: " + eventHostingType);
    	if(eventHostingType.equals("Single event"))
    		driver.click(eventHostingSingle);
    	else
    		driver.click(eventHostingMultiple);
    	driver.isVisible(nextButton);
      	driver.isEnabled(nextButton);
    	driver.click(nextButton);
    
		return this;
    }
    
}
