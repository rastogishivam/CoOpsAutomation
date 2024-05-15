package com.event.pages;

import java.sql.DriverAction;
import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;


public class EventLocation {

	//private static final Logger logger = LogManager.getLogger(EventLocation.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Where will your event take place?']";
    private String nextButton = "button#btnNextEventDuration";
    private String searchAddress = "//input[@id='eventAddressSearch']";
    private String addAddress1 = "//*[@id='jsGrid_vgResults']/div[2]/table/tbody/tr[1]/td[2]/span";
    private String addAddress3 = "//*[@id='jsGrid_vgResults']/div[2]/table/tbody/tr[3]/td[2]/span";

	private String addMultipleLocation = "//button[@id='btnAddLocationMultiple']";
    

    public EventLocation(Page page){
    	driver = page;
    }
    
    public EventLocation isEventLocationPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Where will your event take place? ** visible", isVisible);
    	return this;
    }
    
    public EventLocation searchVenueAddress1(String eventLocation)  {
    	TestLogger.log("Search venue address :: " + eventLocation);
    	driver.click(searchAddress);
    	driver.fill(searchAddress, eventLocation);
    	driver.click(addAddress1);
    	driver.isVisible(nextButton);
      	driver.isEnabled(nextButton);
    	driver.click(nextButton);
    
		return this;
    }

	public EventLocation searchVenueAddress3(String eventLocation)  {
		TestLogger.log("Search venue multiple address :: " + eventLocation);
		driver.click(searchAddress);
		driver.fill(searchAddress, eventLocation);
		driver.click(addAddress3);
		driver.waitForSelector(addMultipleLocation);
		driver.click(addMultipleLocation);
		driver.isVisible(nextButton);
		driver.isEnabled(nextButton);
		driver.click(nextButton);

		return this;
	}
    
}
