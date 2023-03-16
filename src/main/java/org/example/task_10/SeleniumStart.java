package org.example.task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");

        //2

        ChromeDriverManager.getInstance().setup();
        WebDriver cDriver = new ChromeDriver();
        cDriver.get("https//www.google.com");
    }
}
