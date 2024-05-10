package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;


public class LicenceInfo {

    private Page driver;
    private String nextBtn = "button#btnNextVehicleDriversLicense";
	private String nextPageHeader = "div#wf-main-topHtml";
	private String driverLicNotOutsideCanada = "input#radioDriverLicenseType-No";
	private String driverLicOutsideCanada = "input#radioDriverLicenseType-Yes";
	private String driverLicenceClassG = "input#driverLicenseClass-G";
	private String driverLicenceClassG2 = "input#driverLicenseClass-G2";


    public LicenceInfo(Page page){
    	driver = page;
    }

	public LicenceInfo isDriverLicenceOutsideCanada(boolean flag){
		if(flag){
			TestLogger.log("Select the Driver Licence Outside Canada or the US as Yes");
			driver.click(driverLicOutsideCanada);
		}else{
			TestLogger.log("Select the Driver Licence Outside Canada or the US as No");
			driver.click(driverLicNotOutsideCanada);
		}
		return this;
	}

	public LicenceInfo selectDriverLicenceClass(String driverLicenceClass){
		if(driverLicenceClass.equalsIgnoreCase("G")){
			TestLogger.log("Select the Driver Licence Class as G");
			driver.click(driverLicenceClassG);
		}else{
			TestLogger.log("Select the Driver Licence Class as G2");
			driver.click(driverLicenceClassG2);
		}
		return this;
	}

	public LicenceInfo selectAgeToReceiveGLic(String age){
		TestLogger.log("Select the Age to receive the GLIC licence");
		driver.getByLabel("Age when you received your G licence").selectOption(age);
		return this;
	}

	public DrivingExperience clickNextButton() {
		TestLogger.log("Click the next button at Driver Licence Page");
		driver.click(nextBtn);
		driver.waitForSelector(nextPageHeader);
		boolean isVisible = driver.isVisible(nextPageHeader);
		TestLogger.logStepAndVerify("Is the User moved to Driving Experience Page", isVisible);
		return new DrivingExperience(driver);
	}
}
