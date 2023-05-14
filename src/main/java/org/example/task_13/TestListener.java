package org.example.task_13;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.fatal("Te st failed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        LOGGER.info(result.getName());
    }
}
