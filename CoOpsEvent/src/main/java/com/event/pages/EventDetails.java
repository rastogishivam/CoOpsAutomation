package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventDetails {
	//private static final Logger logger = LogManager.getLogger(EventDetails.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Can you tell us more about your event?']";
    private String nextButton = "button#btnNextEventQuoteVisible";
    private String numberOfAttendeesLoc = "//*[@id='numberAttendees']";
    private String numberOfAttendeesLabel = "Number of attendees";
    private String numberAttendees = "//*[@id='numberAttendees']/option[@label='25 or Less']";
  //*[@id='numberAttendees']/option[@label='between 26-125']
    private String alcoholServedLoc = "//*[@id='eventAlcoholServed-No']";
    private String eventNameLoc = "//*[@id='eventName']";

    public EventDetails(Page page){
    	driver = page;
    }
    
    public EventDetails isEventDetailsPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Can you tell us more about your event? ** visible", isVisible);
    	return this;
    }
    
    public EventDetails enterEventDetails(String numberOfAttendees, String alcoholServed, String nameOfEvent)  {
    	driver.click(numberOfAttendeesLoc);
    	driver.getByLabel(numberOfAttendeesLabel).selectOption(numberOfAttendees);
        TestLogger.log("Number Of Attendees entered " + numberOfAttendees);
    	driver.getByText(alcoholServed, new Page.GetByTextOptions().setExact(true)).click();
    	driver.getByPlaceholder("Ex. John’s birthday party").click();
    	driver.getByPlaceholder("Ex. John’s birthday party").fill(nameOfEvent);
        TestLogger.log("Name of event entered " + nameOfEvent);
    	driver.click(nextButton);

		return this;
    }
    
  
    

}
