package com.event.pages;

import java.util.Arrays;

import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.org.coops.logger.TestLogger;

public class EventPaymentDetails {
	//private static final Logger logger = LogManager.getLogger(EventPaymentDetails.class);
    private Page driver;
    private String pageHeader = "//h1[text()='Payment Details']";
    private String creditCardNumber = "//*[@id='bambora-card-number']";
    private String cardHolderName = "//*[@id='name']";
    private String expiryDate = "//*[@id='bambora-expiry']";
    private String cvv = "//*[@id='bambora-cvv']";
//    private String payButton = "button#btnPurchase";
    private String purchaseBtn = "//button[@id='btnPurchase']";
    private String payBtn = "//*[@id='btnPurchase']";
    public static final String CARD_HOLDER_NAME = "MSTest User";
    public static final String CARD_NUMBER = "4030000010001234";
    public static final String CVV = "123";
    public static final String EXPIRY_DATE = "05/31";
    //private String cardHolderName = "input#cardHolderName";
    private String cardNumber = "iframe[name='bambora-card-number-iframe']";
    private String cvvNumber = "iframe[name='bambora-cvv-iframe']";
    private String cardExpiry = "iframe[name='bambora-expiry-iframe']";
    private String nextPageHeader = "div#htmlCovered";

    public EventPaymentDetails(Page page){
    	driver = page;
    }
    
    public EventPaymentDetails isEventPaymentDetailsPageLoaded() {
    	driver.waitForSelector(pageHeader);
    	boolean isVisible = driver.isVisible(pageHeader);
    	TestLogger.logStepAndVerify("Is the Page header **Payment Details ** visible", isVisible);
    	return this;
    }
    
    public EventPaymentDetails enterPaymentDetails()  {
    	
    	 //driver.pause();
    	

         driver.getByPlaceholder("1234 1234 1234 1234").isVisible();
         //driver.locator(creditCardNumber).fill(CARD_NUMBER);
         driver.frameLocator(cardNumber).getByPlaceholder("1234 1234 1234 1234").fill(CARD_NUMBER);
        TestLogger.log("Credit Card Number  :: " +CARD_NUMBER);

         driver.keyboard().press("Tab");
         

         //driver.getByPlaceholder("John Doe").isVisible();
         driver.fill(cardHolderName,CARD_HOLDER_NAME);
        TestLogger.log("Card Holder Name  :: " +CARD_HOLDER_NAME);
         
         driver.keyboard().press("Tab");
         
         driver.getByPlaceholder("MM / YY").isVisible();
         driver.frameLocator(cardExpiry).getByPlaceholder("MM / YY").fill(EXPIRY_DATE);
        TestLogger.log("Expiry Date  :: "+ EXPIRY_DATE);
         //driver.fill(expiryDate,EXPIRY_DATE);
         //driver.keyboard().type(EXPIRY_DATE);
         driver.keyboard().press("Tab");
    
         driver.getByPlaceholder("Your CVV is a 3-digit number on the back of the card").isVisible();
         driver.frameLocator(cvvNumber).getByPlaceholder("Your CVV is a 3-digit number on the back of the card").fill(CVV);
        TestLogger.log("CVV  :: " + CVV);
         clickOnPurchaseBtn();
         
//         driver.waitForTimeout(1000);
         //driver.fill(cvv,CVV);
         //driver.keyboard().type(CVV);
//         driver.keyboard().press("Tab");
        
//         driver.isEnabled(purchaseBtn);
         
//         driver.click(purchaseBtn);
         //driver.click(payBtn);
//         driver.waitForTimeout(15000);

         //driver.pause(); 
//    	driver.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Payment Details")).click();
//    	driver.frameLocator("iframe[name=\"bambora-card-number-iframe\"]").getByPlaceholder("1234 1234 1234").click();
//    	
//        driver.locator("body").click();
//       
//        driver.frameLocator("iframe[name=\"bambora-card-number-iframe\"]").getByPlaceholder("1234 1234 1234").click();
//        driver.frameLocator("iframe[name=\"bambora-card-number-iframe\"]").getByPlaceholder("1234 1234 1234").click(new Locator.ClickOptions()
//          .setModifiers(Arrays.asList(KeyboardModifier.CONTROL)));
//        driver.frameLocator("iframe[name=\"bambora-card-number-iframe\"]").getByPlaceholder("1234 1234 1234").fill("4030000010001234");
//        driver.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("John Doe")).click();
//        driver.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("John Doe")).fill("Test");
//        driver.frameLocator("iframe[name=\"bambora-expiry-iframe\"]").getByPlaceholder("MM / YY").click();
//        driver.frameLocator("iframe[name=\"bambora-expiry-iframe\"]").getByPlaceholder("MM / YY").fill("04 / 30");
//        driver.frameLocator("iframe[name=\"bambora-cvv-iframe\"]").getByPlaceholder("Your CVV is a 3-digit number").click();
//        driver.frameLocator("iframe[name=\"bambora-cvv-iframe\"]").getByPlaceholder("Your CVV is a 3-digit number").fill("123");
    	
//        driver.pause();
        //driver.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay $")).click();
        //driver.dblclick(payButton);
        //driver.click(payBtn);
//        
//        driver.waitForTimeout(25000);
//        driver.pause();        
		return this;
    }
    
    public void clickOnPurchaseBtn() {
    	driver.waitForSelector(purchaseBtn);
    	boolean flagEnabled = driver.isEnabled(purchaseBtn);
        TestLogger.logStepAndVerify("Is Pay Button  ** Pay $ ** enabled", flagEnabled);
    	driver.waitForTimeout(15000);
    	driver.click(purchaseBtn);
    	driver.waitForTimeout(15000);
    	driver.waitForSelector(nextPageHeader);
    	driver.waitForTimeout(15000);
    	boolean flagVisible = driver.isVisible(nextPageHeader);
        TestLogger.logStepAndVerify("Is the next Page header **Congrats! Your event is protected ** visible", flagVisible);
    	System.out.println("You are covered :: " + flagVisible);
    }
}
