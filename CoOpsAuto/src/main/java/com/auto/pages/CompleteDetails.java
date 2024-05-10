package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class CompleteDetails {
    private Page driver;
    private String moreVehicleDetailsRequire = "//button[contains(@id,'btnMoreDetailsNeededVehicle')]";
    private String completeVehicleDetails = "//button[contains(@id,'btnCompleteVehicle')]";
    private String moreDriverDetailsRequire = "//button[contains(@id,'btnMoreDetailsNeededDriver')]";
    private String completeDriverDetails = "//button[contains(@id,'btnCompleteDriver')]";
    private String vehicleDetailsPage = "div#mainHeaderVehicleAdditionalDetails";
    private String driverDetailsPage = "div#htmlDriverAdditionalDetailsHeader";
    private String saveBtn = "button#btnNextVINPurchase";
    private String nextBtn = "button#btnNextDriverAdditionalDetails";
    private String driverLicNumber = "input#driverLicenseNumber";
    private String nextPageHeader = "div#htmlDriverInsuranceHistoryHeader";
    private String saveBtnAtInsuranceHistory = "button#btnNextDriverHistory";
    private String nextBtnToCompleteDetails = "button#btnNextMissingInfo";
    private String nextMainPageHeader = "div#mainHeaderYouDont";
    private String nextBtnMainPage = "button#btnNextYouDont";
    public CompleteDetails(Page page){
        driver = page;
    }

    public CompleteDetails completeVehicleDetails(String vehicleOwnerShip){
        TestLogger.log("Click on Vehicle More Details Needed Button");
        driver.click(moreVehicleDetailsRequire);
        driver.waitForSelector(vehicleDetailsPage);
        boolean isVisible = driver.isVisible(vehicleDetailsPage);
        TestLogger.logStepAndVerify("Is the Ownership Status page opened", isVisible);
        TestLogger.log("Select the Type of vehicle Ownership");
        driver.getByLabel("Type of vehicle ownership").selectOption(vehicleOwnerShip);
        return this;
    }

    public CompleteDetails clickSaveBtn(){
        TestLogger.log("Click to Save button at Ownership Status");
        driver.click(saveBtn);
        driver.waitForSelector(completeVehicleDetails);
        return this;
    }

    public CompleteDetails completeDriverDetails(String driverLicence){
        TestLogger.log("Click on Driver More Details Needed Button");
        driver.click(moreDriverDetailsRequire);
        driver.waitForSelector(driverDetailsPage);
        boolean isVisible = driver.isVisible(driverDetailsPage);
        TestLogger.logStepAndVerify("Is the Driver Licence Consent page opened", isVisible);
        TestLogger.log("Enter the Driver Licence Number :: " + driverLicence);
        driver.fill(driverLicNumber, driverLicence);
        return this;
    }

    public CompleteDetails completeInsuranceHistory(String incompleteInsuranceHistory){
        TestLogger.log("Click on Next button");
        driver.waitForSelector(nextBtn);
        driver.click(nextBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the Your Insurance History Page opened", isVisible);
        driver.getByLabel("Reason for incomplete insurance history").selectOption(incompleteInsuranceHistory);
        driver.click(saveBtnAtInsuranceHistory);
        driver.waitForSelector(completeDriverDetails);
        return this;
    }

    public ReviewYourQuote clickNextButton() {
        TestLogger.log("Click the next button at Complete All Details Page");
        driver.click(nextBtnToCompleteDetails);
        driver.waitForSelector(nextMainPageHeader);
        boolean isVisible = driver.isVisible(nextMainPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Check All That Apply Page", isVisible);
        driver.click(nextBtnMainPage);
        return new ReviewYourQuote(driver);
    }
}
