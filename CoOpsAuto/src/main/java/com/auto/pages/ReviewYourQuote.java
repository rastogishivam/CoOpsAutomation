package com.auto.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import com.org.coops.base.BaseWebPage;
import com.org.coops.logger.TestLogger;
import com.org.coops.utilities.DateUtils;

public class ReviewYourQuote extends BaseWebPage {
    private Page driver;
    private String proceedToBuyBtn = "button#btnNextQuoteHere";
    private String nextPageHeader = "div#htmlMissingInformation";
    private String yearlyFrequency = "input#radioTogglecoverageFrequency-Yearly";
    private String coverageStartDateCalendar = "input#effectiveDateQuote";
    private String reviewYourQuoteHeader = "div#htmlBindQuoteHere";
    private String nextBtn = "//button[@id='btnNextBindHeresYourQuote']";
    private String agreementPageHeader = "div#htmlPaymentHeader";
    private String selectYear = "//select[@class='pika-select pika-select-year']";
    private String selectMonth = "//select[@class='pika-select pika-select-month']";
    private String selectDate = "//button[@data-pika-day='{1}']";

    public ReviewYourQuote(Page page){
        super(page);
        driver = page;
    }

    public ReviewYourQuote selectCoverageFrequency(String frequency){
        TestLogger.log("Select the Policy Coverage Frequency :: " + frequency);
        if(frequency.equalsIgnoreCase("Yearly"))
            driver.click(yearlyFrequency);
        return this;
    }

    public ReviewYourQuote selectCoverageStartDate(String date){
        driver.click(coverageStartDateCalendar);
        if(date.equalsIgnoreCase("today")){
            TestLogger.log("Select the Coverage Start date from today :: " + DateUtils.getCurrentDay());
            String dateLoc = switchToDynamicLocator(selectDate, DateUtils.getCurrentDay());
            driver.click(dateLoc);
        }else{
            String[] dates = date.split("/");
            s_logger.info("Select the Year : " + dates[2]);
            driver.selectOption(selectYear, new SelectOption().setValue(dates[2]));
            String month = String.valueOf(Integer.parseInt(dates[0]) - 1);
            if(month.startsWith("0")){
                month = month.replaceFirst("0", "");
            }
            s_logger.info("Select the Month :: " + month);
            driver.selectOption(selectMonth, new SelectOption().setValue(month));
            s_logger.info("Select the Date :: " + dates[1]);
            String dateLoc = switchToDynamicLocator(selectDate, dates[1]);
            driver.click(dateLoc);
//            driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(dates[1]).setExact(true)).click();
            TestLogger.log("The Coverage Start Date selected :: " + date);
        }
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
