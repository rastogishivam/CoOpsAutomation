package com.event.pages;

import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventCoverage {
	//private static final Logger logger = LogManager.getLogger(EventCoverage.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Let’s personalize your coverage']";
    private String nextButton = "button#btnNextIAlcoholShow";
    private String entiyNameLoc = "input#entityName";
    private String entityEmailIndv = "//*[@id='entityEmailIndv']";
	private String entityEmailBiz = "//*[@id='entityEmailBiz']";
    private String entiyPhoneLoc = "input#entityPhone";
    private String termsOfUseLoc = "//*[@id='termsChkbox']";

	private static String HOST_TYPE_BUSINESS = "A Business";

  

    public EventCoverage(Page page){
    	driver = page;
    }
    
    public EventCoverage isEventCoveragePageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Let’s personalize your coverage ** visible", isVisible);
    	return this;
    }
    
    public EventCoverage enterCoverageDetails(String eventHost, String entityName, String entityEmail, String entityPhone, String province)  {


		driver.getByText(eventHost).click();
		if(HOST_TYPE_BUSINESS.equals(eventHost))
		{
			TestLogger.log("Business Host " + entityName);
			driver.getByLabel("Business name").click();
			driver.getByLabel("Business name ").fill(entityName);
			TestLogger.log("Business Name entered " + entityName);
			driver.locator("#entityProvinceBiz").selectOption(province);
			TestLogger.log("Business Province entered " + province);
			driver.fill(entityEmailBiz, entityEmail);
			TestLogger.log("Email entered " + entityEmail);
			driver.getByPlaceholder("(555) 555-").click();
		}
		else {
			TestLogger.log("Individual Host " + entityName);
			//driver.getByText(eventHost).click();
			driver.getByLabel("Full Name").click();
			driver.getByLabel("Full Name").fill(entityName);
			TestLogger.log("Full Name entered " + entityName);


			driver.locator("#entityProvinceIndv").selectOption(province);
			TestLogger.log("Individual Province entered " + province);
			driver.fill(entityEmailIndv, entityEmail);
			TestLogger.log("Email entered " + entityEmail);
			driver.getByPlaceholder("(555) 555-").click();
		}
      	driver.getByPlaceholder("(555) 555-").fill(entityPhone);
		TestLogger.log("Phone number entered " + entityPhone);
      	driver.getByPlaceholder("(555) 555-").press("Enter");
      	driver.locator("#termsChkboxLabel span").click();
      	driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      	driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
 
		return this;
    }





}
