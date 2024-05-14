package com.event.pages;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventProtected {
	//private static final Logger logger = LogManager.getLogger(EventProtected.class);
	private static final String policyNum = "//*[@id='jsGrid_vgWeddingReception']/div[2]/table/tbody/tr/td[1]/span";
    private Page driver;
    private String pageHeader = "//h1[text()='Congrats! Your event is protected']";
    private String eventDashboardButton = "button#btnEventDashboard";
    private String eventDashboardBtn = "//button[@id='btnEventDashBoard']";
    private String eventDashboardHeader = "//h4[text()='Activate your account']";
    //private String eventDashboardLabel = "//*[@id='panelActivateAccountHtml2']/div/p";
    private String eventOkayButton = "button#btnOkay";
  

    public EventProtected(Page page){
    	driver = page;
    }
    
    public EventProtected isEventProtectedPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Congrats! Your event is protected ** visible", isVisible);
    	return this;
    }
    
    public EventProtected eventDashboard()  {

    	 String policyNumber = driver.innerText(policyNum);
         boolean flag = !policyNumber.isEmpty();
         System.out.println("Policy No :: " + policyNumber);
         TestLogger.logStepAndVerify("Policy created with policy number: " + policyNumber, flag);
    	driver.waitForSelector(eventDashboardBtn);
    	boolean isVisible = driver.isVisible(eventDashboardBtn);
    	driver.isEnabled(eventDashboardBtn);
    	driver.click(eventDashboardBtn);
    	driver.waitForSelector(eventDashboardHeader);
    	boolean flagVisible = driver.isVisible(eventDashboardHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Activate your account ** visible", flagVisible);
    	driver.click(eventOkayButton);
		return this;
    }
    
  
    

}
