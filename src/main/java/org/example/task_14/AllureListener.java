package org.example.task_14;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static org.example.task_12.WebDriverSupplier.driver;

@Log4j
public class AllureListener implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult result){
        screenshot();
        dumpPage();
        log.info("Test success");
    }


    @Override
    public void onTestStart(ITestResult result){
//        screenshot();
        log.info("Test started");
    }

    @Attachment(value="Page screen.png", type="image/png")
    private byte[] screenshot() {
        log.info("Screenshot!");

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value="page dump", type="text/html")
    private String dumpPage() {
        log.info("Saving source code of page");

        return driver.getPageSource();
    }
}
