package com.event.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class EventAdditionalInsureds {

    private Page driver;
    private String pageHeader = "//h1[text()='Details of the additional insured']";
    private String nextButton = "button#btnNext";

    private String addInsuredsBtn = "button#btnAddAdditionalInsured";

    private String addInsuredsEntityName = "input#additionalInsuredNameOrEntity";

    private String addInsuredsEntityEmail = "input#additionalInsuredEmail";

    private static String EVENT_CO_HOST = "Co-host";
    private static String EVENT_ADDITIONAL_INSUREDS = "Additional Insureds";

    private String nextBtn = "button#BtnToAdditionalOrCohost";



    public EventAdditionalInsureds(Page page){
    	driver = page;
    }
    
    public EventAdditionalInsureds isEventAdditionalInsuredsPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header ** Details of the additional insured ** visible", isVisible);
    	return this;
    }

    public EventAdditionalInsureds enterAdditionalInsuredsDetails(String addInsuredsName, String addInsuredsEmail) {

        driver.click(addInsuredsEntityName);
        driver.fill(addInsuredsEntityName,addInsuredsName);
        TestLogger.log("Additional Insureds Name entered " + addInsuredsName);
        driver.click(addInsuredsEntityEmail);
        driver.fill(addInsuredsEntityEmail, addInsuredsEmail);
        TestLogger.log("Additional Insureds Email entered " + addInsuredsEmail);
        driver.waitForSelector(addInsuredsBtn);
        boolean isVisible = driver.isVisible(addInsuredsBtn);
        TestLogger.logStepAndVerify("Is the Add Additional Insureds button ** Add+ ** enabled", isVisible);
        driver.click(addInsuredsBtn);
        TestLogger.log("Click on Add+ button  :: Add+ Additional Insureds");

        return this;
    }

}
