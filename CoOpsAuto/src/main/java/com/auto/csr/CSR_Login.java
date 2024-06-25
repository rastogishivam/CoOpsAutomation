package com.auto.csr;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;
import com.org.coops.logger.TestLogger;

public class CSR_Login extends BaseWebPage {
    private String usrName = "//input[@id='username']";
    private String usrPass = "//input[@id='password']";
    private String submitBtn = "//input[@value='Login']";
    private String nextPageHeader = "//div[@id='jsGrid_gridSubs']";
    private String stylingRemoveBtn = "//button[@aria-label='Remove Preview Bar']";
    private Page driver;

    public CSR_Login(Page page) {
        super(page);
        driver = page;
    }

    public void CSR_Login(Page page){
        driver = page;
    }

    public CSR_Login enterUserName(String userId){
        s_logger.info("Enter the User Name :: " + userId);
        driver.waitForSelector(usrName);
        driver.fill(usrName, userId);
        return this;
    }

    public CSR_Login enterUserPassword(String password){
        s_logger.info("Enter the User Password :: ******");
        driver.waitForSelector(usrPass);
        driver.fill(usrPass, password);
        return this;
    }

    public CSR_Customers clickToSubmitBtn(){
        s_logger.info("Click on Submit button");
        driver.waitForSelector(submitBtn);
        driver.click(submitBtn);
        driver.waitForSelector(nextPageHeader);
        driver.click(stylingRemoveBtn);
        boolean flag = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("User Successfully logged In at Customer Support Portal", flag);
        return new CSR_Customers(driver);
    }

}
