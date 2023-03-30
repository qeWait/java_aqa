package org.example.task_12.wrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.task_12.WebDriverSupplier.driver;
import static org.example.task_12.WebDriverSupplier.getWaitInstance;

public class TextElement extends Element{

    public TextElement(WebElement webElement) {
        super(webElement);
    }

    public String waitForVisibleGetText() {
        System.out.println("Starting waiting for text "+getWebElement());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getWebElement()));
        return getWebElement().getText();
    }

    public boolean waitForTextPresent(String text) {
        return getWaitInstance().until(ExpectedConditions.textToBePresentInElement(getWebElement(), text));
    }
}
