package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class Payment {

    private Page driver;
    private String cardHolderName = "input#cardHolderName";
    private String cardNumber = "iframe[name=\"bambora-card-number-iframe\"]";
    private String cvvNumber = "iframe[name=\"bambora-cvv-iframe\"]";
    private String cardExpiry = "iframe[name=\"bambora-expiry-iframe\"]";
    private String purchaseBtn = "button#btnPurchasePayment";
    private String nextPageHeader = "div#htmlYouAreCoveredHeader";
    public Payment(Page page){
        driver = page;
    }

    public Payment enterCardHolderName(String name){
        TestLogger.log("Enter the Card Holder Name :: " + name);
        driver.fill(cardHolderName, name);
        return this;
    }

    public Payment enterCardNumber(String number){
        TestLogger.log("Enter the Card Number :: " + number);
        driver.frameLocator(cardNumber).getByPlaceholder("E.g.: 1234 1234 1234 1234 ").fill(number);
        return this;
    }

    public Payment enterCVV(String cvv){
        TestLogger.log("Enter the CVV Number :: " + cvv);
        driver.frameLocator(cvvNumber).getByPlaceholder("E.g.: 234").fill(cvv);
        return this;
    }

    public Payment enterExpiryDate(String expiryDate){
        TestLogger.log("Enter the Expiry Date :: " + expiryDate);
        driver.frameLocator(cardExpiry).getByPlaceholder("MM / YY").fill(expiryDate);
        return this;
    }

    public PolicyCovered clickPurchaseButton() {
        TestLogger.log("Click the Purchase Payment button at Payment Page");
        driver.click(purchaseBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to You are Covered Page", isVisible);
        return new PolicyCovered(driver);
    }
}
