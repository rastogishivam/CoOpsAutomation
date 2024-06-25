package com.auto.csr;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;
import com.org.coops.constant.Tdata;
import com.org.coops.logger.TestLogger;

public class CSR_Policies extends BaseWebPage {
    private Page driver;
    private String policyIDFilter = "//input[@id='filterPolicyId']";
    private String searchBtn = "//button[@id='btnFilterSearch']";
    private String foundResults = "(//div[@class='jsgrid-grid-body'])[last()]";
    private String policyIDLink = "//a[text()='{1}']";
    private String dynText = "//span[text()='{1}']";
    private String nextPageHeader = "//div[@id='htmlKickoutAlertsHeader']";
    public CSR_Policies(Page page) {
        super(page);
        driver = page;
    }

    public CSR_Policies searchPolicy(String policyID){
        s_logger.info("Search the Policy with ID :: " + policyID + " at Customer Support Portal.");
        driver.waitForSelector(policyIDFilter);
        driver.fill(policyIDFilter, policyID);
        driver.waitForSelector(searchBtn);
        driver.click(searchBtn);
        driver.waitForSelector(foundResults);
        boolean flag = driver.isVisible(foundResults);
        TestLogger.logStepAndVerify("Policy successfully found at Policies page", flag);
        return this;
    }

    public CSR_PolicyDetails openPolicyDetails(String policyID){
        s_logger.info("Open the Policy Details of ID :: " + policyID);
        driver.waitForSelector(foundResults);
        driver.click(switchToDynamicLocator(policyIDLink, policyID));
        driver.waitForSelector(nextPageHeader);
        boolean flag = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Verified, Is the user moved to Policy Details Page", flag);
        return new CSR_PolicyDetails(driver);
    }

    public CSR_Policies validatePolicyID(String policyID){
        s_logger.info("Validate the Policy ID :: " + policyID);
        String webElement = switchToDynamicLocator(policyIDLink, policyID);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the policy ID is present at Policies page :: " + policyID, flag);
        return this;
    }

    public CSR_Policies validatePrimaryOwnerFstName(String firstName){
        s_logger.info("Validate the Primary Owner First Name :: " + firstName);
        String webElement = switchToDynamicLocator(dynText, firstName);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the Primary Owner First Name is Visible :: " + firstName, flag);
        return this;
    }

    public CSR_Policies validatePrimaryOwnerLstName(String lastName){
        s_logger.info("Validate the Primary Owner Last Name :: " + lastName);
        String webElement = switchToDynamicLocator(dynText, lastName);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the Primary Owner Last Name is Visible :: " + lastName, flag);
        return this;
    }

    public CSR_Policies validatePolicyType(String policyType){
        s_logger.info("Validate the Policy Type :: " + policyType);
        String webElement = switchToDynamicLocator(dynText, policyType);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the Policy Type is Visible :: " + policyType, flag);
        return this;
    }

    public CSR_Policies validateEffectiveDate(String effectiveDate){
        String polEffDate = effectiveDate + Tdata.CSR.DEFAULT_TIME;
        s_logger.info("Validate the Policy Effective Date  :: " + polEffDate);
        String webElement = switchToDynamicLocator(dynText, polEffDate);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the Policy Effective Date is Visible :: " + effectiveDate, flag);
        return this;
    }

    public CSR_Policies validateExpiryDate(String expiryDate){
        String polExpDate = expiryDate + Tdata.CSR.DEFAULT_TIME;
        s_logger.info("Validate the Policy Expiry Date  :: " + polExpDate);
        String webElement = switchToDynamicLocator(dynText, polExpDate);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the Policy Expiry Date is Visible :: " + expiryDate, flag);
        return this;
    }

    public CSR_Policies validatePolicyStatus(String status){
        s_logger.info("Validate the Policy Status  :: " + status);
        String webElement = switchToDynamicLocator(dynText, status);
        driver.waitForSelector(webElement);
        boolean flag = driver.isVisible(webElement);
        TestLogger.logStepAndVerify("Verified, Is the Policy Status is Visible :: " + status, flag);
        return this;
    }
}
