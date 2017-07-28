package com.kreditech.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import static com.kreditech.utilities.CaptureScreenshot.attachScreenshot;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov.
 * BaseTest class starts logging and selects browser for testing.
 * Logger LOG collest all masseges and aggregate it under testName
 * which set in testngstart.xml.
 *
 */
public class BaseTest {

    protected WebDriver driver;
    protected Logger LOG;

    @BeforeClass(alwaysRun = true)
    protected void classSetUp(ITestContext context){
        String testName = context.getCurrentXmlTest().getName();
        LOG = LoggerFactory.getLogger(testName);
        LOG.info("TEST START");
    }

    /**
     *
     * @param browser can be setup:
     *               auto, through @Parameters from testngstart.xml.
     *               manual, from command line (e.g mvn test -Dbrowser=chrome).
     *               default, from parameter @Optional ('firefox') for debugging.
     */
    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    protected void methodSetUp(@Optional("firefox") String browser){
        String bro = System.getProperty("browser");
        if (bro == null||bro.isEmpty()) bro = browser;
        LOG.info("Starting " + bro + " driver");
        driver = BrowserFactory.getDriver(bro);
    }

    @AfterMethod(alwaysRun = true)
    protected void methodTearDown(ITestResult result){
        String testName = result.getTestContext().getCurrentXmlTest().getName();
        LOG = LoggerFactory.getLogger(testName);
        Reporter.setCurrentTestResult(result);
        if (result.isSuccess()) {
            log("TEST FINISHED WITH SUCCESS");
        } else {
            attachScreenshot(driver);
            log("TEST FINISHED WITH FAILURE");
        }

        driver.quit();
    }

    protected void log(String log) {
        LOG.info(log);
        Reporter.log("<p>" + LOG.getName() + " - " + log + "<p>");
    }
}
