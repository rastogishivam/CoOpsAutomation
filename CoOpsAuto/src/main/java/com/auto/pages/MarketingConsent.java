package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class MarketingConsent {

    private Page driver;
    private String nextBtn = "button#btnNextAcknowledgement";
    private String nextPageHeader = "div#htmlQuoteHere";
    private String usrEmail = "input#primaryEmail";
    private String optInCheck = "input#agreeCollection";
    private String userPhone = "input#primaryPhone";
    private String getQuote = "//*[text()='Let’s get you a quote!']";

    public MarketingConsent(Page page){
        driver = page;
    }

    public MarketingConsent enterEmail(String email){
        TestLogger.log("Enter the email :: " + email);
        driver.fill(usrEmail, email);
        return this;
    }

    public MarketingConsent optInConsent(boolean flag){
        if(flag){
            TestLogger.log("User Opted In for the Consent");
            driver.click(optInCheck);
        }else{
            TestLogger.log("User didn't opted the marketing consent.");
        }
        return this;
    }

    public MarketingConsent enterPhoneNum(String phonenum){
        TestLogger.log("Enter the Phone Number for Marketing Consent :: " + phonenum);
        driver.fill(userPhone, phonenum);
        return this;
    }

    public ReviewYourQuote clickNextButton() {
        TestLogger.log("Click the next button at Marketing Consent Page");
        driver.click(nextBtn);
        driver.waitForSelector(getQuote);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Review your Quote Page", isVisible);
        return new ReviewYourQuote(driver);
    }
}
