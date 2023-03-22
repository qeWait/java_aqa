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
        WebDriver driver = new ChromeDriver(options);
//        EdgeDriverManager.getInstance().setup();
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new EdgeDriver(options);
        //go to the page from your variant
        driver.get("https://demoqa.com/elements");

        //choose any 5 different elements;
        //1
        WebElement navItem = driver.findElement(By.xpath("//*[@id=\"item-6\"]"));
        navItem.click();

        //2
        WebElement img = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[2]"));
        System.out.println(img.getSize());
        System.out.println(img.getAttribute("src"));

        //3
        WebElement practiceForm = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
        practiceForm.click();

        //4
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        System.out.println(nameInput.getAttribute("value"));
        nameInput.sendKeys("Pavlo");
        System.out.println(nameInput.getAttribute("value"));

        //5
        WebElement form = driver.findElement(By.xpath("//*[@id=\"userForm\"]"));
        form.submit();
        
        driver.close();
        driver.quit();
    }
}
