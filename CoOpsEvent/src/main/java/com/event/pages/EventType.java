package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;


public class EventType {

	//private static final Logger logger = LogManager.getLogger(EventType.class);
    private Page driver;
    private String pageHeader = "//h1[text()='What type of event are you hosting?']";
    private String iUnderstand = "button#btnAgree";
    private String event = "div#eventType";
    

    public EventType(Page page){
    	driver = page;
    }
    
    public EventType isEventTypePageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header ** What type of event are you hosting? ** visible", isVisible);
    	return this;
    }
    
    public EventType selectEventType(String eventType)  {
    	TestLogger.log("Select your event :: " + eventType);
    	driver.click(event);
    	driver.type(event, eventType);
       	driver.press(event, "Enter");
    	boolean isVisible = driver.isVisible(iUnderstand);
//		TestLogger.logStepAndVerify("Is the Pop Up ** I Understand ** visible", isVisible);
    	driver.click(iUnderstand);
    
		return this;
    }
    
}
