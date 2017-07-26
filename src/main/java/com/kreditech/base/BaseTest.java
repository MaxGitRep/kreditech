package com.kreditech.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov.
 * BaseTest class starts logging and selects browser for testing.
 * Logger LOG collest all masseges and aggregate it under testName
 * which set in testngstart.xml.
 * @param browser can be setup:
 *               auto, through @Parameters from testngstart.xml.
 *               manual, from command line (e.g mvn test -Dbrowser=chrome).
 *               default, from parameter @Optional ('firefox') for debugging.
 *
 */
public class BaseTest {

    protected WebDriver driver;
    protected Logger LOG;

    @BeforeClass(alwaysRun = true)
    protected void classSetUp(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        LOG = LoggerFactory.getLogger(testName);
    }

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    protected void methodSetUp(@Optional("firefox") String browser){
        String bro = System.getProperty("browser");
        if (bro == null||bro.isEmpty()) bro = browser;
        driver = BrowserFactory.getDriver(bro, LOG);
    }

    @AfterMethod(alwaysRun = true)
    protected void methodTearDown(){
        driver.quit();
    }

//    protected void log(String info){
//        LOG.info(info);
//        Reporter.log(info);
//    }
}
