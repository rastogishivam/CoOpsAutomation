package com.auto.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.org.coops.logger.TestLogger;

import java.time.LocalDate;

public class ReviewYourQuote {

    private Page driver;
    private String proceedToBuyBtn = "button#btnNextQuoteHere";
    private String nextPageHeader = "div#htmlMissingInformation";
    private String yearlyFrequency = "input#radioTogglecoverageFrequency-Yearly";
    private String coverageStartDateCalendar = "input#effectiveDateQuote";
    private String reviewYourQuoteHeader = "div#htmlBindQuoteHere";
    private String nextBtn = "button#btnNextBindHeresYourQuote";
    private String agreementPageHeader = "div#htmlPaymentHeader";
    public ReviewYourQuote(Page page){
        driver = page;
    }

    public ReviewYourQuote selectCoverageFrequency(String frequency){
        TestLogger.log("Select the Policy Coverage Frequency :: " + frequency);
        if(frequency.equalsIgnoreCase("Yearly"))
            driver.click(yearlyFrequency);
        return this;
    }

    public ReviewYourQuote selectCoverageStartDateFromToday(){
        LocalDate currentDate = LocalDate.now();
        String dayOfMonth = String.valueOf(currentDate.getDayOfMonth());
        TestLogger.log("Select the Coverage Start date from today :: " + dayOfMonth);
        driver.click(coverageStartDateCalendar);
        driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(dayOfMonth).setExact(true)).click();
        return this;
    }

    public CompleteDetails clickProceedToBuyButton() {
        TestLogger.log("Click the Proceed To Buy button at Review Your Quote");
        driver.waitForSelector(proceedToBuyBtn);
        driver.click(proceedToBuyBtn);
        driver.waitForSelector(nextPageHeader);
        boolean isVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the User moved to Review your Quote Page", isVisible);
        return new CompleteDetails(driver);
    }

    public ReviewAgreement clickToNextBtn(){
        TestLogger.log("Click to Next Button After review the quote");
        driver.waitForSelector(reviewYourQuoteHeader);
        driver.click(nextBtn);
        driver.waitForSelector(agreementPageHeader);
        boolean isVisible = driver.isVisible(agreementPageHeader);
        TestLogger.logStepAndVerify("Is the Important Agreement page visible", isVisible);
        return new ReviewAgreement(driver);
    }
}
