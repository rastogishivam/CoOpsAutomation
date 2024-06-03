package com.auto.csr;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;

public class CSR_Login extends BaseWebPage {
    private String usrName = "//input[@id='username']";
    private Page driver;

    public CSR_Login(Page page) {
        super(page);
        driver = page;
    }

    public void CSR_Login(Page page){
        driver = page;
    }

    public CSR_Login enterUserName(){
        s_logger.info("Enter the User Name :: ");
        driver.waitForSelector(usrName);
        driver.fill(usrName, "Test User");
        return this;
    }

}
