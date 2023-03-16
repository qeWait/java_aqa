package org.example.task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");


//        ChromeDriverManager.getInstance().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver cDriver = new ChromeDriver(chromeOptions);
        cDriver.get("https//jsonplaceholder.typicode.com");

        cDriver.close();
        cDriver.quit();
    }
}
