package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GlobalSQATest extends SeleniumTest {

    @Test
    public void globalSQATest() {
        System.setProperty("webdriver.gecko.driver", "D:\\Users\\Pills\\seleniumDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Step 0: navigate to page
        driver.get("http://globalsqa.com/demo-site/draganddrop");

        // Step 1: Drag 2nd image into trash box
        WebDriverWait waitForFrame = new WebDriverWait(driver, 5);
        waitForFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));

        WebElement secondImage = driver.findElement(By.cssSelector("#gallery > li:nth-child(2) > img"));
        WebElement trash = driver.findElement(By.id("trash"));

        Actions action = new Actions(driver);
        action.dragAndDrop(secondImage, trash).build().perform();
        // Sleep added to help follow along visually
        sleep(2);

        // Step 2: Recycle same image from trash
        WebElement recycleButton = driver.findElement(By.xpath("//a[@title='Recycle this image']"));
        recycleButton.click();

        // Sleep added to help follow along visually
        sleep(2);
    }
}
