package com.kreditech.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by pc on 22.07.2017.
 * @author Max Pavlov
 * Simple listener for adding some logs when starting and finishing test.
 */

public class TestListener extends TestListenerAdapter {

    private Logger LOG;

    @Override
    public void onTestSuccess(ITestResult testResult) {
        LOG = LoggerFactory.getLogger(testResult.getTestContext().getCurrentXmlTest().getName());
        LOG.info("TEST FINISHED WITH SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        LOG = LoggerFactory.getLogger(testResult.getTestContext().getCurrentXmlTest().getName());
        LOG.info("TEST FINISHED WITH FAILURE");
    }

    @Override
    public void onStart(ITestContext testContext) {
        LOG = LoggerFactory.getLogger(testContext.getCurrentXmlTest().getName());
        LOG.info("TEST START\n");
    }
}
