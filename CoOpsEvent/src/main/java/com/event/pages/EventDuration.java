package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventDuration {
	//private static final Logger logger = LogManager.getLogger(EventDuration.class);
    private Page driver;
    private String pageHeader = "//h1[text()='When is your event?']";
    private String nextButton = "button#btnNextEventQuote";
    private String openStart = "button#btnOpenStart";
    private String openEnd = "button#btnOpenEnd";
    private String startDateTitleLoc = "//h1[text()='Start Date']";
    private String endDateTitleLoc = "//h1[text()='End Date']";
    private String startDateLoc = "//*[@id='startDate']";
    private String selectHourLoc = "//*[@id='rdoClockStart']";
    private String selectMinuteLoc = "//*[@id='rdoHourStart']";
    private String selectAmPmLoc = "//*[@id='rdoAmPmStart']";
    private String setButtonLoc = "//*[@id='btnStartEvent']";
    private String endDateLoc = "//*[@id='endDate']";
    private String selectEndHourLoc = "//*[@id='rdoClockEnd']";
    private String selectEndMinuteLoc = "//*[@id='rdoHourEnd']";
    private String selectEndAmPmLoc = "//*[@id='rdoAmPmEnd']";
    private String setEndButtonLoc = "//*[@id='btnEndEvent']";

	private String coverageDays = "//input[@id='eventInsurance']";

	private static String EVENT_HOSTING_TYPE_MULTIPLE = "Multiple events";

    public EventDuration(Page page){
    	driver = page;
    }
    
    public EventDuration isEventDurationPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **When is your event? ** visible", isVisible);
    	return this;
    }
    
    public EventDuration selectStartDate(String startDate, String selectHour, String selectMinute, String selectAmPm)  {
    	driver.click(openStart);
    	driver.waitForSelector(startDateTitleLoc);
    	boolean isVisible = driver.isVisible(startDateTitleLoc);
    	TestLogger.logStepAndVerify("Is the Page title **Start Date ** visible", isVisible);
    	//TestLogger.log("Select your date :: " + eventHostingType);
    	driver.click(startDateLoc);
    	driver.fill(startDateLoc, startDate); 
    	driver.keyboard().press("Enter");
    	driver.click(selectHourLoc);
    	driver.type(selectHourLoc, selectHour);
    	driver.keyboard().press("Enter");
    	driver.click(selectMinuteLoc);
    	driver.type(selectMinuteLoc, selectMinute);
    	driver.keyboard().press("Enter");
    	driver.click(selectAmPmLoc);
    	driver.type(selectAmPmLoc, selectAmPm);
    	driver.keyboard().press("Enter");
    	driver.isVisible(setButtonLoc);
      	driver.isEnabled(setButtonLoc);
    	driver.click(setButtonLoc);
    	driver.waitForSelector(pageHeader);
		boolean isPageHeaderVisible = driver.isVisible(pageHeader);
		TestLogger.logStepAndVerify("Is the Page header **When is your event ** visible", isPageHeaderVisible);
    
		return this;
    }
    
    public EventDuration selectEndDate(String endDate, String selectHour, String selectMinute, String selectAmPm)  {
    	driver.click(openEnd);
    	driver.waitForSelector(endDateTitleLoc);
    	boolean isVisible = driver.isVisible(endDateTitleLoc);
    	TestLogger.logStepAndVerify("Is the Page title **End Date ** visible", isVisible);
    	//TestLogger.log("Select your date :: " + eventHostingType);
    	driver.click(endDateLoc);
    	driver.fill(endDateLoc, endDate); 
    	driver.keyboard().press("Enter");
    	driver.click(selectEndHourLoc);
    	driver.type(selectEndHourLoc, selectHour);
    	driver.keyboard().press("Enter");
    	driver.click(selectEndMinuteLoc);
    	driver.type(selectEndMinuteLoc, selectMinute);
    	driver.keyboard().press("Enter");
    	driver.click(selectEndAmPmLoc);
    	driver.type(selectEndAmPmLoc, selectAmPm);
    	driver.keyboard().press("Enter");
    	driver.isVisible(setEndButtonLoc);
      	driver.isEnabled(setEndButtonLoc);
    	driver.click(setEndButtonLoc);
    	driver.waitForSelector(pageHeader);
    	boolean isPageHeaderVisible = driver.isVisible(pageHeader);
		TestLogger.logStepAndVerify("Is the Page header **When is your event ** visible", isPageHeaderVisible);
    	driver.click(nextButton);
    	//driver.pause();

    
		return this;
    }

	public EventDuration coverageRequiredDays(String eventHostingType, String requiredCoverageDays)
	{
		if(eventHostingType.equals(EVENT_HOSTING_TYPE_MULTIPLE)) {
			driver.fill(coverageDays, requiredCoverageDays);
			TestLogger.log("How many days you require coverage is entered" + requiredCoverageDays);

		}

		return this;
	}
    

}
