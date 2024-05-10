package com.org.coops.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.microsoft.playwright.Page;
import com.org.coops.factory.PlaywrightFactory;

public class BaseTest {

    private static final Logger s_logger = LogManager.getLogger(BaseTest.class);
	PlaywrightFactory factory;
    Properties properties;
    protected static Page page;

    @BeforeClass
    public void setup(ITestContext context){
        String browserName = context.getCurrentXmlTest().getParameter("browser");
        String environment = context.getCurrentXmlTest().getParameter("environment");
        boolean headless = context.getCurrentXmlTest().getParameter("headless").equals("true");
        String url = context.getCurrentXmlTest().getParameter("url");
        factory = new PlaywrightFactory();
        page = factory.initBrowser(environment, browserName, headless, url);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
