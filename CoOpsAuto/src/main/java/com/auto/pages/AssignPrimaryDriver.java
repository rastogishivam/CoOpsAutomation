package com.auto.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.org.coops.logger.TestLogger;

public class AssignPrimaryDriver {

    private Page driver;
    private String nextBtn = "button#btnNextVehicleAssignment";
    private String nextPageHeader = "div#htmlAcknowledgement";

    public AssignPrimaryDriver(Page page){
        driver = page;
    }

    public AssignPrimaryDriver selectPrimaryDriver(String firstName, String lastName){
        String driverName = firstName + " " + lastName;
        TestLogger.log("Select the primary driver for the Vehicle :: " + driverName);
        driver.getByLabel("primaryDriver").selectOption(new SelectOption().setLabel(driverName));
        return this;
    }

    public MarketingConsent clickNextButton() {
        TestLogger.log("Click the next button at Assign Primary Driver Page");
        driver.click(nextBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Marketing consent Page", isVisible);
        return new MarketingConsent(driver);
    }
}
