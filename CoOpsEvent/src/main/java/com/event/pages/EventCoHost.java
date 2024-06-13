package com.event.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class EventCoHost {

    private Page driver;
    private String pageHeader = "//h1[text()='Details of the co-host']";
    private String nextButton = "button#btnNext";

    private String addCohostBtn = "button#btnAddCoHost";

    private String coHostEntityName = "input#cohostNameOrEntity";

    private String coHostEntityEmail = "input#cohostEmail";

    private static String EVENT_CO_HOST = "Co-host";
    private static String EVENT_ADDITIONAL_INSUREDS = "Additional Insureds";

    private String nextBtn = "button#BtnToAdditionalOrCohost";



    public EventCoHost(Page page){
    	driver = page;
    }
    
    public EventCoHost isEventCoHostPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header ** Details of the co-host ** visible", isVisible);
    	return this;
    }

    public EventCoHost enterCoHostDetails(String coHostName, String coHostEmail) {

        driver.click(coHostEntityName);
        driver.fill(coHostEntityName,coHostName);
        TestLogger.log("Co Host Name entered " + coHostName);
        driver.click(coHostEntityEmail);
        driver.fill(coHostEntityEmail, coHostEmail);
        TestLogger.log("Co Host Email entered " + coHostEmail);
        //driver.locator("#form-group-rdoAdd").getByText("Yes").click();
        driver.waitForSelector(addCohostBtn);
        boolean isVisible = driver.isVisible(addCohostBtn);
        TestLogger.logStepAndVerify("Is the Add Co Host button ** Add+ ** enabled", isVisible);
        driver.click(addCohostBtn);
        TestLogger.log("Click on Add+ button  :: Add+ Co Host");
        //driver.locator("#form-group-rdoAdd").getByText("No").click();

        return this;
    }

}
