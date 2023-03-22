package org.example.task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SeleniumStart {
    public static void main(String[] args) {
        //General
        //Setup ChromeDriver using driver file and properties.
        //Setup ChromeDriver using DriverManager.
        //My first UI test:
        //go to the page from your variant
        //choose any 5 different elements;
        //Use different WebElement methods to communicate with those elements. (one element - at least one interaction)
        //Make a testNG test case to check visibility of your elements.

        //Setup ChromeDriver using driver file and properties.
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        //Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver cDriver = new ChromeDriver(options);
        cDriver.get("https://demoqa.com/");

        WebElement img = cDriver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/section/div/div/div/div[1]/div[3]/div/div[1]"));
        System.out.println(img.isDisplayed());

        cDriver.close();
        cDriver.quit();
    }
}
