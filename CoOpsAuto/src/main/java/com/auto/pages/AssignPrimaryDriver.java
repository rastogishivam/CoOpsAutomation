package com.auto.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.org.coops.base.BaseWebPage;
import com.org.coops.logger.TestLogger;

public class AssignPrimaryDriver extends BaseWebPage {

    private Page driver;
    private String nextBtn = "button#btnNextVehicleAssignment";
    private String nextPageHeader = "div#htmlAcknowledgement";
    private String selectDriverFor1stVehicle = "(//select[@aria-label='primaryDriver'])[1]";
    private String selectDriverFor2ndVehicle = "(//select[@aria-label='primaryDriver'])[2]";
    private String selectDriverFor3rdVehicle = "(//select[@aria-label='primaryDriver'])[3]";
    private String selectDriverFor4thVehicle = "(//select[@aria-label='primaryDriver'])[4]";

    public AssignPrimaryDriver(Page page){
        super(page);
        driver = page;
    }

    public AssignPrimaryDriver selectDriverFor1stVehicle(String firstName, String lastName){
        String driverName = firstName + " " + lastName;
        TestLogger.log("Select the primary driver for the 1st Vehicle :: " + driverName);
        driver.selectOption(selectDriverFor1stVehicle, new SelectOption().setLabel(driverName));
        return this;
    }

    public AssignPrimaryDriver selectDriverFor2ndVehicle(String firstName, String lastName){
        String driverName = firstName + " " + lastName;
        TestLogger.log("Select the primary driver for the 2nd Vehicle :: " + driverName);
        driver.selectOption(selectDriverFor2ndVehicle, new SelectOption().setLabel(driverName));
        return this;
    }

    public AssignPrimaryDriver selectDriverFor3rdVehicle(String firstName, String lastName){
        String driverName = firstName + " " + lastName;
        TestLogger.log("Select the primary driver for the 3rd Vehicle :: " + driverName);
        driver.selectOption(selectDriverFor3rdVehicle, new SelectOption().setLabel(driverName));
        return this;
    }

    public AssignPrimaryDriver selectDriverFord4thVehicle(String firstName, String lastName){
        String driverName = firstName + " " + lastName;
        TestLogger.log("Select the primary driver for the 3rd Vehicle :: " + driverName);
        driver.selectOption(selectDriverFor4thVehicle, new SelectOption().setLabel(driverName));
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
