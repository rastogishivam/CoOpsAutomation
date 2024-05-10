package com.auto.e2e;

import com.auto.pages.*;
import com.org.coops.constant.Tdata;
import org.testng.annotations.Test;
import com.org.coops.base.BaseTest;
import com.org.coops.utilities.DataProviderUtils;

public class Ford_EndToEndScenarios extends BaseTest{

	@Test(description = "Validate to Purchase the policy with 1 Vehicle and 1 Driver", priority = 1, dataProvider = "Ford_UI", dataProviderClass = DataProviderUtils.class)
    public void validate_Ford_E2EScenario_1Driver_1Vehicle(String vinNumber, String homeAddress, String yearlyKM, String driverFirstName, String driverLastName, String sex, String marital, String dob, String driverLicClass, String ageForGLic, String email, String phoneNum, String driverLic, String addInfo){		Welcome welcome = new Welcome(page);
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

		welcome.clickOnStartYourQuoteBtn().isAboutHomePageLoaded();

		vehicle.enterVinNumber(vinNumber).enterHomeAddress(homeAddress).clickNextButton();

		purchaseInfo.isVehicleCondNew(true).clickNextButton();

		vehicleInfo.selectYearlyKM(yearlyKM).isBusinessUse(false).isCommercialUse(false).clickNextButton();

		driverInformation.enterFirstName(driverFirstName).enterLastName(driverLastName).selectDriverSex(sex).selectDriverMaritalStatus(marital).selectDOB(dob).clickNextButton();

		licenceInfo.isDriverLicenceOutsideCanada(false).selectDriverLicenceClass(driverLicClass).selectAgeToReceiveGLic(ageForGLic).clickNextButton();

		drivingExperience.hasMajorConvictions(false).hasAccidentsInLastTenYears(false).clickNextButton();

		assignPrimaryDriver.selectPrimaryDriver(driverFirstName, driverLastName).clickNextButton();

		consent.enterEmail(email).enterPhoneNum(phoneNum).optInConsent(true).clickNextButton();

		reviewYourQuote.selectCoverageFrequency(Tdata.ReviewYourQuote.COVERAGE_FREQ).selectCoverageStartDateFromToday().clickProceedToBuyButton();

		details.completeVehicleDetails(Tdata.completeDetails.OWNED).clickSaveBtn().completeDriverDetails(driverLic).completeInsuranceHistory(Tdata.completeDetails.INSURANCE_HISTORY).clickNextButton();

		reviewYourQuote.clickToNextBtn();

		reviewAgreement.qualificationAgreement(true).digitalDocDelivery(true).privacyConsent(true).clickGotoPaymentButton();

		payment.enterCardHolderName(Tdata.Payment.CARD_HOLDER_NAME).enterCardNumber(Tdata.Payment.CARD_NUMBER).enterCVV(Tdata.Payment.CVV).enterExpiryDate(Tdata.Payment.EXPIRY_DATE).clickPurchaseButton();
    }
}


