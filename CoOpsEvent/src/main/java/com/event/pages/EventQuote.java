package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventQuote {
	//private static final Logger logger = LogManager.getLogger(EventQuote.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Your Quote']";
    private String nextButton = "button#btnNext";
    private String entiyNameLoc = "input#entityName";
    private String entityEmailLoc = "//*[@id='entityEmailIndv']";
    private String entiyPhoneLoc = "input#entityPhone";
    private String termsOfUseLoc = "//*[@id='termsChkbox']";
    private String nxtpageHeader = "//h1[text()='Add others to your policy']";

	private String alcoholPageHeader = "//h1[text()='Alcohol at your event']";
  

    public EventQuote(Page page){
    	driver = page;
    }
    
    public EventQuote isEventQuotePageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Your Quote ** visible", isVisible);
    	return this;
    }
    
    public EventQuote enterQuoteDetails(String alcoholServed)  {
		boolean flag = false;
		if(alcoholServed.equals("Yes"))
			flag = true;
		driver.isVisible(nextButton);
      	driver.isEnabled(nextButton);
      	driver.waitForTimeout(15000);
    	driver.click(nextButton);
		TestLogger.log("Click on Next button  :: Your Quote");
    	driver.waitForTimeout(15000);
		if(flag){
			driver.waitForSelector(alcoholPageHeader);
			boolean isVisible = driver.isVisible(alcoholPageHeader);
			TestLogger.logStepAndVerify("Is the Page header **Alcohol at your event ** visible", isVisible);}
		else{
			driver.waitForSelector(nxtpageHeader);
			boolean isVisible = driver.isVisible(nxtpageHeader);
			TestLogger.logStepAndVerify("Is the Page header **Add others to your policy ** visible", isVisible);}
    	return this;
    }



    
}
