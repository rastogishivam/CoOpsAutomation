package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventAddedInsurance {
	//private static final Logger logger = LogManager.getLogger(EventAddedInsurance.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Add others to your policy']";
    private String nextButton = "button#btnNext";
    private String addPolicyLoc =  "//*[@id='rdoAdd-No']";

  

    public EventAddedInsurance(Page page){
    	driver = page;
    }
    
    public EventAddedInsurance isEventAddedInsurancePageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Add others to your policy ** visible", isVisible);
    	return this;
    }
    
    public EventAddedInsurance enterAddedInsuranceDetails()  {

    	driver.locator("#form-group-rdoAdd").getByText("No").click();

		return this;
    }
    
  
    

}
