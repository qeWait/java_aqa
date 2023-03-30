package org.example.task_12.po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import java.util.Date;

import static org.example.task_12.WebDriverSupplier.driver;

public abstract class BasePage {

    public abstract boolean isOpen();

    public boolean isLoaded() {
        boolean res = ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        System.out.println("Page state is " + (res?"ready":"not ready"));
        return res;
    };

    public void waitForAlertInMSeconds(long delay) throws InterruptedException {
        long pullingTime = 100;
        long startTime = new Date().getTime();
        while (new Date().getTime() < (startTime+delay)) {
            try {
                driver.switchTo().alert().getText();
                return;
            } catch (NoAlertPresentException e) {
                Thread.sleep(pullingTime);
            }

        }
    }
}
