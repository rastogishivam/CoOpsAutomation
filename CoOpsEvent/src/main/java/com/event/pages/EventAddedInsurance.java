package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventAddedInsurance {
	//private static final Logger logger = LogManager.getLogger(EventAddedInsurance.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Add others to your policy']";

    private String coHostpageHeader = "//h1[text()='Details of the co-host']";

    private String addInsuredpageHeader = "//h1[text()='Details of the additional insured']";
    private String nextButton = "button#btnNext";
    private String addPolicyNo =  "//*[@id='rdoAdd-No']";
    private String addPolicyYes =  "//*[@id='rdoAdd-Yes']";

    private String coHost = "//*[@id='form-group-rdoInsuredsOrCohost']/div[1]/div[2]/label/span";

    private String insureds = "//*[@id='form-group-rdoInsuredsOrCohost']/div[1]/div[3]/label/span";

    private static String EVENT_CO_HOST = "Co-host";
    private static String EVENT_ADDITIONAL_INSUREDS = "Additional Insureds";

    private String nextBtn = "button#BtnToAdditionalOrCohost";

  

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
    public EventAddedInsurance enterAddedInsuranceDetails(String addPolicy)  {
        if(EVENT_CO_HOST.equals(addPolicy)) {
            driver.locator("#form-group-rdoAdd").getByText("Yes").click();
            //driver.waitForSelector(coHost);
            //driver.pause();
            driver.click(coHost);
            driver.click(nextBtn);

        }else if(EVENT_ADDITIONAL_INSUREDS.equals(addPolicy)) {
            driver.locator("#form-group-rdoAdd").getByText("Yes").click();
            //driver.waitForSelector(insureds);
            driver.click(insureds);
            driver.click(nextBtn);
        }
        else{
            driver.locator("#form-group-rdoAdd").getByText("No").click();
        }
        return this;
    }

    public EventCoHost isEventCoHostPageLoaded() {
        driver.waitForSelector(coHostpageHeader);
        boolean isVisible = driver.isVisible(coHostpageHeader);
        TestLogger.logStepAndVerify("Is the Page header ** Details of the co-host ** visible", isVisible);
        return new EventCoHost(driver);
    }
    public EventAdditionalInsureds isEventAdditionalInsuredsPageLoaded() {
        driver.waitForSelector(addInsuredpageHeader);
        boolean isVisible = driver.isVisible(addInsuredpageHeader);
        TestLogger.logStepAndVerify("Is the Page header ** Details of the additional insured ** visible", isVisible);
        return new EventAdditionalInsureds(driver);
    }
}
