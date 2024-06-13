package com.event.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class EventAlcohol {
	//private static final Logger logger = LogManager.getLogger(EventQuote.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Alcohol at your event']";
    private String nextButton = "button#btnNextAddedInsurance";

	private String alcoholVenueYes = "//*[@id='eventVenueResponsible-Yes']";

	private String alcoholVenueNo = "//*[@id='eventVenueResponsible-No']";

    private String chkAlcoholCertification = "//*[@id='chkAlcoholCerification']";
    private String nxtpageHeader = "//h1[text()='Add others to your policy']";


    public EventAlcohol(Page page){
    	driver = page;
    }
    
    public EventAlcohol isEventAlcoholServedPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Alcohol at your event ** visible", isVisible);
    	return this;
    }
    
    public EventAlcohol eventVenueResponsible(String alcoholVenue)  {
    	driver.isVisible(alcoholVenueYes);
		//driver.pause();
		driver.getByLabel("Will you be responsible for").getByText("No").click();
		TestLogger.log("Will you be responsible for is clicked:: No");
		driver.click(chkAlcoholCertification);
		TestLogger.log("Check Box Alcohol Certification is clicked :: True");
		driver.isVisible(nextButton);
		driver.isEnabled(nextButton);
    	driver.click(nextButton);
		TestLogger.log("Click on Next button  :: Alcohol at your event");
    	driver.waitForSelector(nxtpageHeader);
    	boolean isVisible = driver.isVisible(nxtpageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Add others to your policy ** visible", isVisible);
    	
    	return this;
    }

    
}
