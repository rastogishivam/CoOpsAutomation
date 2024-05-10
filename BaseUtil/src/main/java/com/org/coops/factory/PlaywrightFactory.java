package com.org.coops.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.microsoft.playwright.*;

public class PlaywrightFactory {

	private static final Logger s_logger = LogManager.getLogger(PlaywrightFactory.class);
    protected static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    protected static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    protected static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    protected static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    Properties properties;

    public Page initBrowser(String env, String browserName, boolean headless, String url){
        if(env.equalsIgnoreCase("QA")){
            s_logger.info("Initializing the Browser :: " + browserName);
            tlPlaywright.set(Playwright.create());
            switch (browserName.toLowerCase()){
                case "chromium":
                    tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(600)));
                    break;

                case "firefox":
                    tlBrowser.set(getPlayWright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
                    break;

                case "safari":
                    tlBrowser.set(getPlayWright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
                    break;

                case "chrome":
                    tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless).setSlowMo(600)));
                    break;

                default:
                    s_logger.error("Please pass the right browser name");
                    break;
            }
            tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080)));
            tlPage.set(getBrowserContext().newPage());
            getPage().navigate(url);
        }else {
            s_logger.error("The page object not initialized correctly, please check the environment.");
        }
        return getPage();
    }

    public static Playwright getPlayWright(){
        return tlPlaywright.get();
    }

    public static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
    }

    public static Browser getBrowser(){
        return tlBrowser.get();
    }

    public static Page getPage(){
        return tlPage.get();
    }

    public Properties init_prop(){
        try {
            System.out.println("User Directory ::: " + System.getProperty("user.dir"));
            FileInputStream  fileInputStream = new FileInputStream(new File(System.getProperty("user.dir").replace("\\","/") + "/src/main/resources/Config/config.properties"));
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
