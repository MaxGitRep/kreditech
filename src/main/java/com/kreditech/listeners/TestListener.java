package com.kreditech.listeners;

import com.kreditech.base.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.kreditech.utilities.CaptureScreenshot.attachScreenshot;

/**
 * Created by pc on 22.07.2017.
 * @author Max Pavlov
 * Simple listener for adding some logs when starting and finishing test.
 */

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult testResult) {
        log(testResult.getTestContext().getCurrentXmlTest().getName(), "TEST FINISHED WITH SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        attachScreenshot(BrowserFactory.driver);
        log(testResult.getTestContext().getCurrentXmlTest().getName(), "TEST FINISHED WITH FAILURE");
    }

    @Override
    public void onStart(ITestContext testContext) {
        log(testContext.getCurrentXmlTest().getName(), "\nTEST START\n");
    }

    private void log(String testName, String log) {
        Logger LOG = LoggerFactory.getLogger(testName);
        LOG.info(log);
        Reporter.log("<p>" + LOG.getName() + " - " + log + "<p>");
    }

//    public void attachScreenshot() {
//        File scrFile = ((TakesScreenshot) BrowserFactory.driver).getScreenshotAs(OutputType.FILE);
//        String timeFolder = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
//        String timeStamp = new SimpleDateFormat("dd_HHmmss").format(Calendar.getInstance().getTime());
//        String filePath = File.separator + "screenshots" + File.separator + timeFolder + File.separator + timeStamp + ".png";
//
//        File screenShotName = new File("." + File.separator + "results" + filePath);
//        //save screenshot
//        try {
//            FileUtils.copyFile(scrFile, screenShotName);
//        } catch (IOException e) {
//            System.out.println("Exception while taking ScreenShot " + e.getMessage());
//        }
//        //add screenshot to report
//        String aLink = "<a href='"+ "." + filePath + "' target='_blank'>";
//        String imgScr = "<img src='" + "." + filePath + "' height='108' width='192'/></a>";
//        Reporter.log(aLink + imgScr);
//    }

}
