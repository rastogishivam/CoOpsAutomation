package com.org.coops.base;

import java.nio.file.Paths;

import com.org.coops.constant.Constant;
import com.org.coops.logger.TestLogger;
import com.org.coops.utilities.DateUtils;
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
    }

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

    public static String captureScreenshot(){
        String path = Constant.FAILED_IMG_PATH;
        if(path.startsWith("/")){
            path = path.replaceFirst("/","");
        }
        String imageName = "screenshot_" + DateUtils.getCurrentDateWithTime() + ".png";
        path = path + imageName;
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
        System.out.println("Image Name :: " + imageName);
        return imageName;
    }
}
