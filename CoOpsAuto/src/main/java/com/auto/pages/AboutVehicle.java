package com.auto.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.org.coops.logger.TestLogger;


public class AboutVehicle {

    private Page driver;
    private String vin = "input#vinAutomatic";
    private String pageHeader = "//h1[text()='Tell us about your vehicle']";
    private String identifiedVehicleDetails = "div#form-group-vehicleDescription";
    private String homeAddressInput = "input#vehicleAddress";
    private String nextBtn = "button#btnNextVinAddress";
	private String nextPageHeader = "div#wf-main-topHtml";
    

    public AboutVehicle(Page page){
    	driver = page;
    }

	public AboutVehicle selectTrim(String trim){
		TestLogger.log("Select trim of the Vehicle :: " + trim);
		driver.getByLabel("Select Trim").selectOption(new SelectOption().setLabel(trim));
		return this;
	}
    
    public AboutVehicle isAboutHomePageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Verified : After clicked on Start Your Quote Button, user moved to page ** Tell us about your vehicle **", isVisible);
    	return this;
    }
    
    public AboutVehicle enterVinNumber(String vinNumber) {
    	TestLogger.log("Enter the VIN Number :: " + vinNumber);
    	driver.fill(vin, vinNumber);
    	driver.click(pageHeader);
    	driver.waitForSelector(identifiedVehicleDetails);
    	return this;
    }
    
    public AboutVehicle enterHomeAddress(String homeAddress) {
    	TestLogger.log("Enter the Home Address :: " + homeAddress);
    	driver.fill(homeAddressInput, homeAddress);
    	driver.click(pageHeader);
    	driver.waitForSelector(nextBtn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		boolean isEnabled = driver.isEnabled(nextBtn);
    	TestLogger.logStepAndVerify("Is the Next Button enabled, after entered the address", isEnabled);
    	return this;
    }

	public VehiclePurchaseInfo clickNextButton() {
		TestLogger.log("Click the next button at About Your Vehicle Page");
		driver.isEnabled(nextBtn);
		driver.click(nextBtn);
		driver.waitForSelector(nextPageHeader);
		boolean isVisible = driver.isVisible(nextPageHeader);
		TestLogger.logStepAndVerify("Is the User moved to Vehicle Purchase Information Page", isVisible);
		return new VehiclePurchaseInfo(driver);
	}
}
