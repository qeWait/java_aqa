package org.example.task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) {
//        System.setProperty("webdriver.edge.driver","driver/msedgedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");


        EdgeDriverManager.getInstance().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver cDriver = new EdgeDriver(options);
        cDriver.get("https//google.com/");

//        cDriver.close();
//        cDriver.quit();
    }
}
