package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class DrivingExperience {

    private Page driver;
    private String nextBtn = "button#btnNextConvictions";
    private String nextPageHeader = "div#htmlVehicleAssignmentTitle";
    private String noMajorConvictions = "input#hasMajorConvictions-No";
    private String majorConvictions = "input#hasMajorConvictions-Yes";
    private String noAccidentInLast10Year = "input#hasAccidentsInLastTenYears-No";
    private String accidentInLast10Year = "input#hasAccidentsInLastTenYears-Yes";
    private String btnAddDriver = "button#btnAddDriver";
    private String addtionalDriverPopUp = "div#htmlConvictionHardStopHeader";
    private String gotItBtn = "button#btnDriverSameAddress";
    private String driverInfoHeader = "div#htmlDriverHeading";

    public DrivingExperience(Page page){
        driver = page;
    }

    public DrivingExperience hasMajorConvictions(boolean flag){
        if(flag){
            TestLogger.log("Select Any major, serious, or criminal convictions in the last 3 years as Yes");
            driver.click(majorConvictions);
        }else{
            TestLogger.log("Select Any major, serious, or criminal convictions in the last 3 years as No");
            driver.click(noMajorConvictions);
        }
        return this;
    }

    public DrivingExperience hasAccidentsInLastTenYears(boolean flag){
        if(flag){
            TestLogger.log("Select Any at-fault accidents in the last 10 years as Yes");
            driver.click(accidentInLast10Year);
        }else{
            TestLogger.log("Select Any at-fault accidents in the last 10 years as No");
            driver.click(noAccidentInLast10Year);
        }
        return this;
    }

    public AssignPrimaryDriver clickNextButton() {
        TestLogger.log("Click the next button at Driver Experience Page");
        driver.click(nextBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Assign a primary driver to each vehicle Page", isVisible);
        return new AssignPrimaryDriver(driver);
    }

    public DriverInformation clickAddDriverBtn(){
        TestLogger.log("Click the Add Driver button at Driver Experience Page");
        driver.click(btnAddDriver);
        driver.waitForSelector(addtionalDriverPopUp);
        driver.click(gotItBtn);
        driver.waitForSelector(driverInfoHeader);
        boolean isVisible = driver.isVisible(driverInfoHeader);
        TestLogger.logStepAndVerify("Is the User moved to Driver Information Page to add driver details", isVisible);
        return new DriverInformation(driver);
    }
}
