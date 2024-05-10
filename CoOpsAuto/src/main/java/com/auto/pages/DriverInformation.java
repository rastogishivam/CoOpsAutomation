package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class DriverInformation {

    private Page driver;
    private String nextBtn = "button#btnNextDriverName";
    private String nextPageHeader = "div#htmlDriversLicenseTitle";
    private String dFirstName = "input#firstName";
    private String dLastName = "input#lastName";
    private String date = "input#driverDateOfBirthDay";
    private String year = "input#driverDateOfBirthYear";

    public DriverInformation(Page page){
        driver = page;
    }

    public DriverInformation enterFirstName(String firstName){
        TestLogger.log("Enter the Driver First Name :: " + firstName);
        driver.fill(dFirstName, firstName);
        return this;
    }

    public DriverInformation enterLastName(String lastName){
        TestLogger.log("Enter the Driver Last Name :: " + lastName);
        driver.fill(dLastName, lastName);
        return this;
    }

    public DriverInformation selectDriverSex(String sex){
        TestLogger.log("Select the Driver Sex Status :: " + sex);
        driver.getByLabel("Sex").selectOption(sex);
        return this;
    }

    public DriverInformation selectDriverMaritalStatus(String maritalStatus){
        TestLogger.log("Select the Driver Marital Status :: " + maritalStatus);
        driver.getByLabel("Marital status").selectOption(maritalStatus);
        return this;
    }

    public DriverInformation selectDOB(String dob){
        TestLogger.log("Select the Driver DOB :: " + dob);
        String[] driverDOB = dob.replace(",", "").split(" ");
        driver.getByLabel("Month").selectOption(driverDOB[0]);
        driver.locator(date).fill(driverDOB[1]);
        driver.locator(year).fill(driverDOB[2]);
        return this;
    }

    public LicenceInfo clickNextButton(){
        TestLogger.log("Click the next button of Driver Information Page");
        driver.click(nextBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the user moved to Licence Information page", isVisible);
        return new LicenceInfo(driver);
    }
}
