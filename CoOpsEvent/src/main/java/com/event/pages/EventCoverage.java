package com.event.pages;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;
import com.event.constants.Constants;

//import static com.event.constants.Constants.DUPLICATE_EMAIL_ERROR;

public class EventCoverage {
	//private static final Logger logger = LogManager.getLogger(EventCoverage.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Let’s personalize your coverage']";
    private String nextButton = "button#btnNextIAlcoholShow";
    private String entiyNameLoc = "input#entityName";
    private String entityEmailIndv = "//*[@id='entityEmailIndv']";
	private String entityEmailBiz = "//*[@id='entityEmailBiz']";

	private String loginBtn = "//button[@id='btnLoginPortal']";
    private String entiyPhoneLoc = "input#entityPhone";
    private String termsOfUseLoc = "//*[@id='termsChkbox']";

	private static String HOST_TYPE_BUSINESS = "A Business";

	private static String accountExists = "//h3[text()='An account is already registered with this email address. Please enter a different email or log in.']";

	private static String accountExistsMsg = "An account is already registered with this email address. Please enter a different email or log in.";

  

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
		}
		TestLogger.log("Email entered " + entityEmail);
		driver.getByPlaceholder("(555) 555-").click();
		driver.getByPlaceholder("(555) 555-").fill(entityPhone);
		TestLogger.log("Phone number entered " + entityPhone);
      	driver.getByPlaceholder("(555) 555-").press("Enter");
      	driver.locator("#termsChkboxLabel span").click();
      	driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      	driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		return this;
    }


	public EventCoverage isAccountAlreadyRegisteredLoaded() {
		driver.waitForSelector(accountExists);
		boolean isVisible = driver.isVisible(accountExists);
		TestLogger.logStepAndVerify("Is the Duplicate Email Message error **An account is already registered with this email address. ** visible", isVisible);
		//driver.getByLabel("Close").click();
		driver.click(loginBtn);
		TestLogger.log("Login Button clicked");


		return this;
	}


}
