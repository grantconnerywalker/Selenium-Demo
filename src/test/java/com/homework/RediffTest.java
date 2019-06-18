package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RediffTest {

    WebDriver driver;

    @AfterTest
    public void teardown() {
        driver.close();
    }

    @Test
    public void exampleTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\Pills\\seleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "D:\\Users\\Pills\\seleniumDrivers\\geckodriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //open the url or AUT
        driver.get("http://newtours.demoaut.com/");

        //Click on the register link:
        WebElement lnk_register = driver.findElement(By.linkText("REGISTER"));
        lnk_register.click();

        //Enter details on the provided text boxes by using sendkeys method.
        WebElement txtBox_firstname = driver.findElement(By.name("firstName"));
        txtBox_firstname.sendKeys("John");

        //or directly we can identify element and act on that in one line
        driver.findElement(By.name("lastName")).sendKeys("Clark");
        driver.findElement(By.name("phone")).sendKeys("2342342341");
        driver.findElement(By.name("userName")).sendKeys("sunilpatro1985@gmail.com");
    }

}
