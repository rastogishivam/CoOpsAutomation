package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.logger.TestLogger;

public class PolicyCovered {
    private Page driver;
    private String policyNum = "//div[@id='htmlPolicyNumber']/div/div";
    public PolicyCovered(Page page){
        driver = page;
    }

    public PolicyCovered validatePolicyNum(){
        String policyN = driver.innerText(policyNum);
        boolean flag = !policyN.isEmpty();
        TestLogger.logStepAndVerify("Policy number has been generated - " + policyN, flag);
        return this;
    }
}
