package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;


public class VehiclePurchaseInfo {

    private Page driver;
    private String nextBtn = "button#btnNextVehiclePurchaseDate";
	private String nextPageHeader = "div#html";
	private String newVehicleCond = "input#purchaseCondition-New";
	private String usedVehicleCond = "input#purchaseCondition-Used";
	private String notOptInTelematics = "input#hasConnectedAdvantageDiscount-No";
	private String optInTelematics = "input#hasConnectedAdvantageDiscount-Yes";


    public VehiclePurchaseInfo(Page page){
    	driver = page;
    }

	public VehiclePurchaseInfo isVehicleCondNew(boolean flag){
		if(flag){
			TestLogger.log("Select the Vehicle Condition as New");
			driver.click(newVehicleCond);
		}else {
			TestLogger.log("Select the Vehicle Condition as Used");
			driver.click(usedVehicleCond);
		}
		return this;
	}

	public VehiclePurchaseInfo optInTelematics(boolean flag){
		if(flag){
			TestLogger.log("Select the opt-in for Telematics as Yes");
			driver.click(optInTelematics);
		}else {
			TestLogger.log("Select the opt-in for Telematics as No");
			driver.click(notOptInTelematics);
		}
		return this;
	}
	public UsedVehicleInfo clickNextButton() {
		TestLogger.log("Click the next button at About Your Vehicle Page");
		driver.click(nextBtn);
		driver.waitForSelector(nextPageHeader);
		boolean isVisible = driver.isVisible(nextPageHeader);
		TestLogger.logStepAndVerify("Is the User moved to Vehicle Purchase Information Page", isVisible);
		return new UsedVehicleInfo(driver);
	}
}
