package com.kreditech.listeners;

import com.kreditech.base.BrowserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


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

    public void onTestStart(ITestResult testResult) {
        log(testResult.getTestContext().getCurrentXmlTest().getName(), "TEST START\n");
    }

    private void log(String testName, String log) {
        Logger LOG = LoggerFactory.getLogger(testName);
        LOG.info(log);
        Reporter.log("<p>" + LOG.getName() + " - " + log + "<p>");
    }
}
