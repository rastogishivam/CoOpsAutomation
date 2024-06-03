package com.org.coops.factory;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;

public class CSRFactory {
    private static final Logger s_logger = LogManager.getLogger(CSRFactory.class);
    private static boolean isCSRLogin = false;
    private static String csrURL;
    private static String usrInput = "//input[@id='username']";

    public static void setupCSR(ITestContext context){
        isCSRLogin = context.getCurrentXmlTest().getParameter("isCSR_Login").equals("true");
        csrURL = context.getCurrentXmlTest().getParameter("csr_url");
    }

    public static void navigateToCSR(Page driver){
        if(isCSRLogin){
            s_logger.info("Navigate To Customer Support Portal at URL :: " + csrURL);
            driver.navigate(csrURL);
            driver.waitForSelector(usrInput);
        }else {
            s_logger.info("isCSR_URL flag is not set as true to navigate to CSR Portal.");
        }
    }

    public void closeCSRTab(){

    }
}
