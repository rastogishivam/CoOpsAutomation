package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class ReviewAgreement {

    private Page driver;
    private String cardDisclaimerBtn = "button#cardDisclaimerBtn";
    private String agreeDisclaimerBtn = "button#agreeDisclaimerBtn";
    private String disAgreeDisclaimerBtn = "button#disAgreeDisclaimerBtn";
    private String digitalDeliveryDocumentBtn = "button#digitalDeliveryDocumentBtn";
    private String agreeDigitalBtn = "button#agreeDigitalBtn";
    private String disAgreeDigitalBtn = "button#disAgreeDigitalBtn";
    private String btnPrivacyConsent = "button#btnPrivacyConsent";
    private String agreePrivacyBtn = "button#agreePrivacyBtn";
    private String disAgreePrivacyBtn = "button#disAgreePrivacyBtn";
    private String gotoPaymentBtn = "button#btnNextReadAndAccept";
    private String nextPageHeader = "div#paymentTitle";
    public ReviewAgreement(Page page){
        driver = page;
    }

    public ReviewAgreement qualificationAgreement(boolean flag){
        TestLogger.log("Open the Qualification Agreement.");
        driver.click(cardDisclaimerBtn);
        if(flag){
            TestLogger.log("Accept the Qualification Agreement");
            driver.waitForSelector(agreeDisclaimerBtn);
            driver.click(agreeDisclaimerBtn);
        }else{
            TestLogger.log("Decline the Qualification Agreement");
            driver.waitForSelector(disAgreeDisclaimerBtn);
            driver.click(disAgreeDisclaimerBtn);
        }
        return this;
    }

    public ReviewAgreement digitalDocDelivery(boolean flag){
        TestLogger.log("Open the Digital Document Delivery Agreement");
        driver.click(digitalDeliveryDocumentBtn);
        if(flag){
            TestLogger.log("Accept the Digital Document Delivery Agreement");
            driver.waitForSelector(agreeDigitalBtn);
            driver.click(agreeDigitalBtn);
        }else {
            TestLogger.log("Decline the Digital Document Delivery Agreement");
            driver.waitForSelector(disAgreeDigitalBtn);
            driver.click(disAgreeDigitalBtn);
        }
        return this;
    }

    public ReviewAgreement privacyConsent(boolean flag){
        TestLogger.log("Open the Privacy Consent Agreement");
        driver.click(btnPrivacyConsent);
        if(flag){
            TestLogger.log("Accept the Privacy Consent Agreement");
            driver.waitForSelector(agreePrivacyBtn);
            driver.click(agreePrivacyBtn);
        }else{
            TestLogger.log("Decline the Privacy Consent Agreement");
            driver.waitForSelector(disAgreePrivacyBtn);
            driver.click(disAgreePrivacyBtn);
        }
        return this;
    }

    public MarketingConsent clickGotoPaymentButton() {
        TestLogger.log("Click the Goto Payment button at Review Agreement Page");
        driver.click(gotoPaymentBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Payment Page", isVisible);
        return new MarketingConsent(driver);
    }
}
