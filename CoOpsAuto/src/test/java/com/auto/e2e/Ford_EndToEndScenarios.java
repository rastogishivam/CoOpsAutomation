package com.auto.e2e;

import com.auto.pages.*;
import com.org.coops.constant.Tdata;
import org.testng.annotations.Test;
import com.org.coops.base.BaseTest;
import com.org.coops.utilities.DataProviderUtils;

public class Ford_EndToEndScenarios extends BaseTest{


	@Test(description = "Validate to Purchase the policy with 1 Vehicle and 1 Driver", priority = 1, dataProvider = "fordUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Ford_E2EScenario_1Driver_1Vehicle(String vinNumber, String homeAddress, String yearlyKM, String driverFirstName, String driverLastName, String sex, String marital, String dob, String driverLicClass, String ageForGLic, String email, String phoneNum, String coverageStartDate, String driverLic, String addInfo){
		Welcome welcome = new Welcome(page);
		AboutVehicle vehicle = new AboutVehicle(page);
		VehiclePurchaseInfo purchaseInfo = new VehiclePurchaseInfo(page);
		UsedVehicleInfo vehicleInfo = new UsedVehicleInfo(page);
		DriverInformation driverInformation = new DriverInformation(page);
		LicenceInfo licenceInfo = new LicenceInfo(page);
		DrivingExperience drivingExperience = new DrivingExperience(page);
		AssignPrimaryDriver assignPrimaryDriver = new AssignPrimaryDriver(page);
		MarketingConsent consent = new MarketingConsent(page);
		ReviewYourQuote reviewYourQuote = new ReviewYourQuote(page);
		CompleteDetails details = new CompleteDetails(page);
		ReviewAgreement reviewAgreement = new ReviewAgreement(page);
		Payment payment = new Payment(page);
		PolicyCovered policyCovered = new PolicyCovered(page);

		welcome.clickOnStartYourQuoteBtn().isAboutHomePageLoaded();

		vehicle.enterVinNumber(vinNumber).enterHomeAddress(homeAddress).clickNextButton();

		purchaseInfo.isVehicleCondNew(true).clickNextButton();

		vehicleInfo.selectYearlyKM(yearlyKM).isBusinessUse(false).isCommercialUse(false).clickNextButton();

		driverInformation.enterFirstName(driverFirstName).enterLastName(driverLastName).selectDriverSex(sex).selectDriverMaritalStatus(marital).selectDOB(dob).clickNextButton();

		licenceInfo.isDriverLicenceOutsideCanada(false).selectDriverLicenceClass(driverLicClass).selectAgeToReceiveGLic(ageForGLic).clickNextButton();

		drivingExperience.hasMajorConvictions(false).hasAccidentsInLastTenYears(false).clickNextButton();

		assignPrimaryDriver.selectDriverFor1stVehicle(driverFirstName, driverLastName).clickNextButton();

		consent.enterEmail(email).enterPhoneNum(phoneNum).optInConsent(true).clickNextButton();

		reviewYourQuote.selectCoverageFrequency(Tdata.ReviewYourQuote.COVERAGE_FREQ).selectCoverageStartDate(coverageStartDate).clickProceedToBuyButton();

		details.completeVehicleDetails(Tdata.completeDetails.OWNED).clickSaveBtn().completeDriverDetails(driverLic).completeInsuranceHistory(Tdata.completeDetails.INSURANCE_HISTORY).clickNextButton();

		reviewYourQuote.clickToNextBtn();

		reviewAgreement.qualificationAgreement(true).digitalDocDelivery(true).privacyConsent(true).clickGotoPaymentButton();

		payment.enterCardHolderName(Tdata.Payment.CARD_HOLDER_NAME).enterCardNumber(Tdata.Payment.CARD_NUMBER).enterCVV(Tdata.Payment.CVV).enterExpiryDate(Tdata.Payment.EXPIRY_DATE).clickPurchaseButton();

		policyCovered.validatePolicyNum();
    }

	@Test(description = "Validate to Purchase the policy with 2 Vehicle and 1 Driver", priority = 2, dataProvider = "fordUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
	public void validate_Ford_E2EScenario_1Driver_2Vehicle(String vinNumber, String vinNumber2, String trim, String homeAddress, String yearlyKM, String driverFirstName, String driverLastName, String sex, String marital, String dob, String driverLicClass, String ageForGLic, String email, String phoneNum, String coverageStartDate, String driverLic, String addInfo){
		Welcome welcome = new Welcome(page);
		AboutVehicle vehicle = new AboutVehicle(page);
		VehiclePurchaseInfo purchaseInfo = new VehiclePurchaseInfo(page);
		UsedVehicleInfo vehicleInfo = new UsedVehicleInfo(page);
		DriverInformation driverInformation = new DriverInformation(page);
		LicenceInfo licenceInfo = new LicenceInfo(page);
		DrivingExperience drivingExperience = new DrivingExperience(page);
		AssignPrimaryDriver assignPrimaryDriver = new AssignPrimaryDriver(page);
		MarketingConsent consent = new MarketingConsent(page);
		ReviewYourQuote reviewYourQuote = new ReviewYourQuote(page);
		CompleteDetails details = new CompleteDetails(page);
		ReviewAgreement reviewAgreement = new ReviewAgreement(page);
		Payment payment = new Payment(page);
		PolicyCovered policyCovered = new PolicyCovered(page);

		welcome.clickOnStartYourQuoteBtn().isAboutHomePageLoaded();

		vehicle.enterVinNumber(vinNumber).enterHomeAddress(homeAddress).clickNextButton();

		purchaseInfo.isVehicleCondNew(true).clickNextButton();

		vehicleInfo.selectYearlyKM(yearlyKM).isBusinessUse(false).isCommercialUse(false).clickAddVehicle();

		vehicle.enterVinNumber(vinNumber2).selectTrim(trim).clickNextButton();

		purchaseInfo.isVehicleCondNew(true).optInTelematics(false).clickNextButton();

		vehicleInfo.selectYearlyKM(yearlyKM).isBusinessUse(false).isCommercialUse(false).clickNextButton();

		driverInformation.enterFirstName(driverFirstName).enterLastName(driverLastName).selectDriverSex(sex).selectDriverMaritalStatus(marital).selectDOB(dob).clickNextButton();

		licenceInfo.isDriverLicenceOutsideCanada(false).selectDriverLicenceClass(driverLicClass).selectAgeToReceiveGLic(ageForGLic).clickNextButton();

		drivingExperience.hasMajorConvictions(false).hasAccidentsInLastTenYears(false).clickNextButton();

		assignPrimaryDriver.selectDriverFor1stVehicle(driverFirstName, driverLastName).selectDriverFor2ndVehicle(driverFirstName, driverLastName).clickNextButton();

		consent.enterEmail(email).enterPhoneNum(phoneNum).optInConsent(true).clickNextButton();

		reviewYourQuote.selectCoverageFrequency(Tdata.ReviewYourQuote.COVERAGE_FREQ).selectCoverageStartDate(coverageStartDate).clickProceedToBuyButton();

		details.completeVehicleDetails(Tdata.completeDetails.OWNED).clickSaveBtn().completeDriverDetails(driverLic).completeInsuranceHistory(Tdata.completeDetails.INSURANCE_HISTORY).clickNextButton();

		reviewYourQuote.clickToNextBtn();

		reviewAgreement.qualificationAgreement(true).digitalDocDelivery(true).privacyConsent(true).clickGotoPaymentButton();

		payment.enterCardHolderName(Tdata.Payment.CARD_HOLDER_NAME).enterCardNumber(Tdata.Payment.CARD_NUMBER).enterCVV(Tdata.Payment.CVV).enterExpiryDate(Tdata.Payment.EXPIRY_DATE).clickPurchaseButton();

		policyCovered.validatePolicyNum();
	}

	@Test(description = "Validate to Purchase the policy with 2 Vehicle and 2 Driver", priority = 3, dataProvider = "fordUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
		public void validate_Ford_E2EScenario_2Driver_2Vehicle(String vinNumber, String vinNumber2, String trim, String homeAddress, String yearlyKM, String driverFirstName, String driverLastName, String sex, String marital, String dob, String secondDriverFirstName, String secondDriverLastName, String secondDriversex, String secondDrivermarital, String secondDriverdob, String driverLicClass, String ageForGLic, String email, String phoneNum, String coverageStartDate, String driverLic, String secondDriverLic, String addInfo){
		Welcome welcome = new Welcome(page);
		AboutVehicle vehicle = new AboutVehicle(page);
		VehiclePurchaseInfo purchaseInfo = new VehiclePurchaseInfo(page);
		UsedVehicleInfo vehicleInfo = new UsedVehicleInfo(page);
		DriverInformation driverInformation = new DriverInformation(page);
		LicenceInfo licenceInfo = new LicenceInfo(page);
		DrivingExperience drivingExperience = new DrivingExperience(page);
		AssignPrimaryDriver assignPrimaryDriver = new AssignPrimaryDriver(page);
		MarketingConsent consent = new MarketingConsent(page);
		ReviewYourQuote reviewYourQuote = new ReviewYourQuote(page);
		CompleteDetails details = new CompleteDetails(page);
		ReviewAgreement reviewAgreement = new ReviewAgreement(page);
		Payment payment = new Payment(page);
		PolicyCovered policyCovered = new PolicyCovered(page);

		welcome.clickOnStartYourQuoteBtn().isAboutHomePageLoaded();

		vehicle.enterVinNumber(vinNumber).enterHomeAddress(homeAddress).clickNextButton();

		purchaseInfo.isVehicleCondNew(true).clickNextButton();

		vehicleInfo.selectYearlyKM(yearlyKM).isBusinessUse(false).isCommercialUse(false).clickAddVehicle();

		vehicle.enterVinNumber(vinNumber2).selectTrim(trim).clickNextButton();

		purchaseInfo.isVehicleCondNew(true).optInTelematics(false).clickNextButton();

		vehicleInfo.selectYearlyKM(yearlyKM).isBusinessUse(false).isCommercialUse(false).clickNextButton();

		driverInformation.enterFirstName(driverFirstName).enterLastName(driverLastName).selectDriverSex(sex).selectDriverMaritalStatus(marital).selectDOB(dob).clickNextButton();

		licenceInfo.isDriverLicenceOutsideCanada(false).selectDriverLicenceClass(driverLicClass).selectAgeToReceiveGLic(ageForGLic).clickNextButton();

		drivingExperience.hasMajorConvictions(false).hasAccidentsInLastTenYears(false).clickAddDriverBtn();

		driverInformation.enterFirstName(secondDriverFirstName).enterLastName(secondDriverLastName).selectDriverSex(secondDriversex).selectDriverMaritalStatus(secondDrivermarital).selectDOB(secondDriverdob).clickNextButton();

		licenceInfo.isDriverLicenceOutsideCanada(false).selectDriverLicenceClass(driverLicClass).selectAgeToReceiveGLic(ageForGLic).selectYearForG2Lic().clickNextButton();

		drivingExperience.hasMajorConvictions(false).hasAccidentsInLastTenYears(false).clickNextButton();

		assignPrimaryDriver.selectDriverFor1stVehicle(driverFirstName, driverLastName).selectDriverFor2ndVehicle(secondDriverFirstName, secondDriverLastName).clickNextButton();

		consent.enterEmail(email).enterPhoneNum(phoneNum).optInConsent(true).clickNextButton();

		reviewYourQuote.selectCoverageFrequency(Tdata.ReviewYourQuote.COVERAGE_FREQ).selectCoverageStartDate(coverageStartDate).clickProceedToBuyButton();

		details.fill2VehicleDetails(driverFirstName, driverLastName, Tdata.completeDetails.OWNED, secondDriverFirstName, secondDriverLastName, Tdata.completeDetails.OWNED).fillDriverDetails(driverFirstName, driverLastName, driverLic).fillDriverDetails(secondDriverFirstName, secondDriverLastName, secondDriverLic).clickNextButton();

		reviewYourQuote.clickToNextBtn();

		reviewAgreement.qualificationAgreement(true).digitalDocDelivery(true).privacyConsent(true).clickGotoPaymentButton();

		payment.enterCardHolderName(Tdata.Payment.CARD_HOLDER_NAME).enterCardNumber(Tdata.Payment.CARD_NUMBER).enterCVV(Tdata.Payment.CVV).enterExpiryDate(Tdata.Payment.EXPIRY_DATE).clickPurchaseButton();

		policyCovered.validatePolicyNum();
	}
}