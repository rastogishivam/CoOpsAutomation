package com.event.pages;

import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventReviewAddedInsurance {
	//private static final Logger logger = LogManager.getLogger(EventReviewAddedInsurance.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Review Additional Insureds and Co-hosts']";
    private String purchaseInsurance = "button#btnPurchaseNew";
    private String proofOfInsurance = "//*[@id='chkPermission']";
  

    public EventReviewAddedInsurance(Page page){
    	driver = page;
    }
    
    public EventReviewAddedInsurance isEventReviewAddedInsurancePageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Review Additional Insureds and Co-hosts ** visible", isVisible);
    	return this;
    }
    
    public EventReviewAddedInsurance reviewAddedInsuranceDetails()  {
        driver.locator("#chkPermissionLabel span").click();
        driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Purchase Insurance")).click();
    
		return this;
    }

}
