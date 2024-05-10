package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;


public class UsedVehicleInfo {

    private Page driver;
    private String nextBtn = "button#btnNextYearlyKilometers";
	private String nextPageHeader = "div#htmlDriverHeading";
	private String businessUse = "input#isForBusinessUse-yes";
	private String businessNotUse = "input#isForBusinessUse-no";
	private String commercialUse = "input#isForCommercialUse-Yes";
	private String commercialNotUse = "input#isForCommercialUse-No";


    public UsedVehicleInfo(Page page){
    	driver = page;
    }

	public UsedVehicleInfo selectYearlyKM(String km){
		TestLogger.log("Selecting yearly KM: " + km);
		driver.getByLabel("Yearly kilometres").selectOption(km);
		return this;
	}

	public UsedVehicleInfo isBusinessUse(boolean flag){
		if(flag){
			TestLogger.log("Select the Business Use as Yes");
			driver.click(businessUse);
		}else {
			TestLogger.log("Select the Business Use as No");
			driver.click(businessNotUse);
		}
		return this;
	}

	public UsedVehicleInfo isCommercialUse(boolean flag){
		if(flag){
			TestLogger.log("Select the Commercial Use as Yes");
			driver.click(commercialUse);
		}else {
			TestLogger.log("Select the Commercial Use as No");
			driver.click(commercialNotUse);
		}
		return this;
	}

	public DriverInformation clickNextButton() {
		TestLogger.log("Click the next button at About Your Vehicle Page");
		driver.click(nextBtn);
		driver.waitForSelector(nextPageHeader);
		boolean isVisible = driver.isVisible(nextPageHeader);
		TestLogger.logStepAndVerify("Is the User moved to How is this vehicle used? Page", isVisible);
		return new DriverInformation(driver);
	}
}
