package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;
import com.org.coops.constant.Tdata;
import com.org.coops.logger.TestLogger;

public class CompleteDetails extends BaseWebPage {
    private Page driver;
    private String  moreVehicleDetailsRequirefor1st = "(//button[contains(@id,'btnMoreDetailsNeededVehicle')])[1]";
    private String moreVehicleDetailsRequirefor2nd = "(//button[contains(@id,'btnMoreDetailsNeededVehicle')])[2]";
    private String completeVehicleDetailsFor1st = "(//button[contains(@id,'btnCompleteVehicle')])[1]";
    private String completeVehicleDetailsFor2nd = "(//button[contains(@id,'btnCompleteVehicle')])[2]";
    private String moreDriverDetailsRequirefor1st = "(//button[contains(@id,'btnMoreDetailsNeededDriver')])[1]";
    private String moreDriverDetailsRequirefor2nd = "(//button[contains(@id,'btnMoreDetailsNeededDriver')])[2]";
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
    private String selectRegisterOwner = "//input[@value='{1}']/parent::label";
    private String incompleteInsuranceHistory = "select#driverInsuranceHistoryIncompleteReason";
    private String driverNoPriorInsuranceReason = "select#driverNoPriorInsuranceReason";
    private String more4DetailsBtn = "//div[contains(@name,'ugDriversMissingInfoForm')]/descendant::*[text()='{1}']/ancestor::*[contains(@name,'ugDriversMissingInfoForm')]/*/following-sibling::*[contains(@id,'form-group-btnMoreDetailsNeededDriver')]/button";
    private String completedMore4Details = "//div[contains(@name,'ugDriversMissingInfoForm')]/descendant::*[text()='{1}']/ancestor::*[contains(@name,'ugDriversMissingInfoForm')]/*/following-sibling::*[contains(@id,'btnCompleteDriver')]/button";
    public CompleteDetails(Page page){
        super(page);
        driver = page;
    }

    public CompleteDetails fill2VehicleDetails(String driverFirstName, String driverLastName, String vehicleOwnerShip, String secondDriverFirstName, String secondDriverLastName, String secondVehicleOwnerShip){
        TestLogger.log("Click on Vehicle More Details Needed Button");
        driver.click(moreVehicleDetailsRequirefor1st);
        driver.waitForSelector(vehicleDetailsPage);
        boolean isVisible = driver.isVisible(vehicleDetailsPage);
        TestLogger.logStepAndVerify("Is the Ownership Status page opened", isVisible);
        String driverOwner = driverFirstName + " " + driverLastName;
        String dynloc = switchToDynamicLocator(selectRegisterOwner, driverOwner);
        TestLogger.log("Select the Register Owner :: " + driverOwner);
        System.out.println("Locator ::: " + dynloc);
        driver.click(dynloc);
        TestLogger.log("Select the Type of vehicle Ownership");
        driver.getByLabel("Type of vehicle ownership").selectOption(vehicleOwnerShip);
        TestLogger.log("Click to Save button at Ownership Status");
        driver.click(saveBtn);
        driver.waitForSelector(completeVehicleDetailsFor1st);
        driver.isVisible(completeVehicleDetailsFor1st);
        wait(3);

        TestLogger.log("Click on Vehicle More Details Needed Button");
        driver.click(moreVehicleDetailsRequirefor2nd);
        driver.waitForSelector(vehicleDetailsPage);
        isVisible = driver.isVisible(vehicleDetailsPage);
        TestLogger.logStepAndVerify("Is the Ownership Status page opened", isVisible);
        driverOwner = secondDriverFirstName + " " + secondDriverLastName;
        dynloc = switchToDynamicLocator(selectRegisterOwner, driverOwner);
        TestLogger.log("Select the Register Owner :: " + driverOwner);
        driver.click(dynloc);
        TestLogger.log("Select the Type of vehicle Ownership");
        driver.getByLabel("Type of vehicle ownership").selectOption(secondVehicleOwnerShip);
        TestLogger.log("Click to Save button at Ownership Status");
        driver.click(saveBtn);
        driver.waitForSelector(completeVehicleDetailsFor2nd);
        driver.isVisible(completeVehicleDetailsFor2nd);
        wait(3);
        return this;
    }
    public CompleteDetails completeVehicleDetails(String vehicleOwnerShip){
        TestLogger.log("Click on Vehicle More Details Needed Button");
        driver.click(moreVehicleDetailsRequirefor1st);
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
        driver.waitForSelector(completeVehicleDetailsFor1st);
        return this;
    }

    public CompleteDetails fillDriverDetails(String driverFirstName, String driverLastName, String licence){
        String driverFullName = driverFirstName + " " + driverLastName;
        TestLogger.log("Click on Driver More Details Needed Button");
        String more4LessLocator = switchToDynamicLocator(more4DetailsBtn, driverFullName);
        driver.waitForSelector(more4LessLocator);
        driver.click(more4LessLocator);
        driver.waitForSelector(driverLicNumber);
        boolean isVisible = driver.isVisible(driverLicNumber);
        TestLogger.logStepAndVerify("Verified :Driver’s licence consent page opened", isVisible);
        driver.isEditable(driverLicNumber);
        driver.click(driverLicNumber, new Page.ClickOptions().setClickCount(5));
        driver.keyboard().press("Backspace");
        driver.keyboard().type(licence);
        driver.click(driverDetailsPage);
        TestLogger.log("Click on Next button at Driver’s licence consent screen");
        driver.waitForSelector(nextBtn);
        driver.isEnabled(nextBtn);
        driver.click(nextBtn);
        fillInsuranceHistory(driverFullName, Tdata.completeDetails.INSURANCE_HISTORY);
        return this;
    }

    private CompleteDetails fillInsuranceHistory(String driverFullName, String reason){
        TestLogger.log("Your Insurance History Page opened.");
        wait(3);
        boolean isVisible = false;
        try{
            driver.waitForSelector(incompleteInsuranceHistory);
            isVisible = driver.isVisible(incompleteInsuranceHistory);
            TestLogger.logStepAndVerify("Verified : Your Insurance History Page opened", isVisible);
            driver.getByLabel("Reason for incomplete insurance history").selectOption(reason);
        }catch (Exception e){
            driver.waitForSelector(driverNoPriorInsuranceReason);
            isVisible = driver.isVisible(driverNoPriorInsuranceReason);
            TestLogger.logStepAndVerify("Verified : Your Insurance History Page opened", isVisible);
            driver.getByLabel("Reason for lack of prior insurance").selectOption(reason);
        }
        driver.waitForSelector(saveBtnAtInsuranceHistory);
        driver.isEnabled(saveBtnAtInsuranceHistory);
        driver.click(saveBtnAtInsuranceHistory);
        String completeBtnLocator = switchToDynamicLocator(completedMore4Details, driverFullName);
        driver.waitForSelector(completeBtnLocator);
        isVisible = driver.isVisible(completeBtnLocator);
        TestLogger.logStepAndVerify("Verified: User navigated to Complete All Details page after filled the driver details", isVisible);
        return this;
    }

    public CompleteDetails fill2DriverDetails(String driverLicence, String secondDriverLicence){
        TestLogger.log("Click on Driver More Details Needed Button");
        driver.click(moreDriverDetailsRequirefor1st);
        driver.waitForSelector(driverDetailsPage);
        boolean isVisible = driver.isVisible(driverDetailsPage);
        TestLogger.logStepAndVerify("Is the Driver Licence Consent page opened", isVisible);
        TestLogger.log("Enter the Driver Licence Number :: " + driverLicence);
        driver.fill(driverLicNumber, driverLicence);
        completeInsuranceHistory(Tdata.completeDetails.INSURANCE_HISTORY);

        TestLogger.log("Click on Driver More Details Needed Button");
        driver.click(moreDriverDetailsRequirefor2nd);
        driver.waitForSelector(driverDetailsPage);
        isVisible = driver.isVisible(driverDetailsPage);
        TestLogger.logStepAndVerify("Is the Driver Licence Consent page opened", isVisible);
        TestLogger.log("Enter the Driver Licence Number :: " + secondDriverLicence);
        wait(5);
        driver.isEditable(driverLicNumber);
        driver.click(driverLicNumber, new Page.ClickOptions().setClickCount(5));
        driver.keyboard().press("Backspace");
        driver.keyboard().type(secondDriverLicence);
        completeInsuranceHistory(Tdata.completeDetails.INSURANCE_HISTORY);
        driver.waitForSelector(saveBtnAtInsuranceHistory);
        driver.isEnabled(saveBtnAtInsuranceHistory);
        driver.click(saveBtnAtInsuranceHistory);
        return this;
    }

    public CompleteDetails completeDriverDetails(String driverLicence){
        TestLogger.log("Click on Driver More Details Needed Button");
        driver.click(moreDriverDetailsRequirefor1st);
        driver.waitForSelector(driverDetailsPage);
        boolean isVisible = driver.isVisible(driverDetailsPage);
        TestLogger.logStepAndVerify("Is the Driver Licence Consent page opened", isVisible);
        TestLogger.log("Enter the Driver Licence Number :: " + driverLicence);
        driver.fill(driverLicNumber, driverLicence);
        return this;
    }

    public CompleteDetails completeInsuranceHistory(String incompleteInsuranceHistory){
        TestLogger.log("Click on Next button at Driver’s licence consent screen");
        wait(3);
        driver.waitForSelector(nextBtn);
        driver.isEnabled(nextBtn);
        driver.click(nextBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the Your Insurance History Page opened", isVisible);
        driver.getByLabel("Reason for incomplete insurance history").selectOption(incompleteInsuranceHistory);
        driver.isEnabled(saveBtnAtInsuranceHistory);
        driver.click(saveBtnAtInsuranceHistory);
        wait(3);
        driver.isVisible(completeDriverDetails);
        wait(3);
        return this;
    }

    public ReviewYourQuote clickNextButton() {
        TestLogger.log("Click the next button at Complete All Details Page");
        driver.isEnabled(nextBtnToCompleteDetails);
        driver.click(nextBtnToCompleteDetails);
        driver.waitForSelector(nextMainPageHeader);
        boolean isVisible = driver.isVisible(nextMainPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Check All That Apply Page", isVisible);
        driver.click(nextBtnMainPage);
        return new ReviewYourQuote(driver);
    }
}
