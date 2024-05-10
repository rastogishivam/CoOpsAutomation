package com.auto.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class Welcome {

    private Page driver;
    private String startYourQuoteBtn = "button#btnNextWelcome";
    private String agreeBtn = "button#btnAgree";

    public Welcome(Page page){
        driver = page;
    }

    public AboutVehicle clickOnStartYourQuoteBtn(){
    	driver.waitForLoadState(LoadState.LOAD);
    	driver.waitForSelector(startYourQuoteBtn);
    	boolean isEnabled = driver.isEnabled(startYourQuoteBtn);
    	driver.click(startYourQuoteBtn);
    	driver.isVisible(agreeBtn);
    	driver.click(agreeBtn);
        TestLogger.logStepAndVerify("Verified : Welcome page loaded and user clicked on Start Your Quote Button", isEnabled);
    	Assert.assertTrue(isEnabled);
        return new AboutVehicle(driver);
    }
}
