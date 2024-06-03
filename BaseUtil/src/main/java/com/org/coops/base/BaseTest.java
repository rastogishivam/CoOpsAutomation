package com.org.coops.base;

import com.org.coops.factory.CSRFactory;
import com.org.coops.logger.TestLogger;
import com.org.coops.utilities.FileUtils;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.microsoft.playwright.Page;
import com.org.coops.factory.PlaywrightFactory;

public class BaseTest {
	PlaywrightFactory factory;
    public static Page page;

    @BeforeSuite
    public void init(ITestContext context){
        FileUtils.init();
        TestLogger.init(context);
        CSRFactory.setupCSR(context);
    }

    @BeforeMethod
    public void setup(ITestContext context){
        String browserName = context.getCurrentXmlTest().getParameter("browser");
        String environment = context.getCurrentXmlTest().getParameter("environment");
        boolean headless = context.getCurrentXmlTest().getParameter("headless").equals("true");
        String url = context.getCurrentXmlTest().getParameter("url");
        factory = new PlaywrightFactory();
        page = factory.initBrowser(environment, browserName, headless, url);
    }

    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }

    public void navigateToCSR(){
        CSRFactory.navigateToCSR(page);
    }
}
