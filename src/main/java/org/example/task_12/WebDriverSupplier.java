package org.example.task_12;

//Implement PageFactory for a few pages.
//        Implement Wrapper for common WebElements (choose your wariant).
//        Implement methods for your web element with console logging. Choose your wariant with specific methods


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSupplier {
    public static ChromeDriver driver;
    public static WebDriverWait wait;


    public static WebDriverWait getWaitInstance(){
        if(wait == null) wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait;
    }
}
