package com.auto.pages;

import com.microsoft.playwright.Page;
import com.org.coops.base.BaseWebPage;
import com.org.coops.logger.TestLogger;

public class PolicyCovered extends BaseWebPage {
    private Page driver;
    private String policyNum = "//div[@id='htmlPolicyNumber']/div/div";
    private String policyNumber;
    public PolicyCovered(Page page){
        super(page);
        driver = page;
    }

    public PolicyCovered validatePolicyNum(){
        policyNumber = driver.innerText(policyNum);
        boolean flag = !policyNumber.isEmpty();
        TestLogger.logStepAndVerify("Policy number has been generated - " + policyNumber, flag);
        return this;
    }

    public String getPolicyNum(){
        if(!policyNumber.isEmpty()){
            s_logger.info("Policy Number is : " + policyNumber);
            return policyNumber.replace("Policy #: ","");
        }else{
            s_logger.info("Policy Number is not generated, please check : " + policyNumber);
            return null;
        }
    }
}
