package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;


public class VehiclePurchaseInfo {

    private Page driver;
    private String nextBtn = "button#btnNextVehiclePurchaseDate";
	private String nextPageHeader = "div#html";
	private String newVehicleCond = "input#purchaseCondition-New";
	private String usedVehicleCond = "input#purchaseCondition-Used";


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

	public UsedVehicleInfo clickNextButton() {
		TestLogger.log("Click the next button at About Your Vehicle Page");
		driver.click(nextBtn);
		driver.waitForSelector(nextPageHeader);
		boolean isVisible = driver.isVisible(nextPageHeader);
		TestLogger.logStepAndVerify("Is the User moved to Vehicle Purchase Information Page", isVisible);
		return new UsedVehicleInfo(driver);
	}
}
