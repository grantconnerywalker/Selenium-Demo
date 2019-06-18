package com.homework;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MakeMyTripTest extends SeleniumTest{
//    WebDriver driver;
//
//    // TODO try making master test class which these tests extend, stick driver and @AfterTest in there
//    @AfterTest
//    public void teardown() {
//        driver.quit();
//    }

    @Test
    public void exampleTest() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Users\\Pills\\seleniumDrivers\\chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "D:\\Users\\Pills\\seleniumDrivers\\geckodriver.exe");

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

    @Test
    public void makeMyTripTest() {
        // Step 0: navigate to page
        driver.get("https://www.makemytrip.com/");

        // Step 1: Enter search criteria into web page
        driver.findElement(By.cssSelector(".searchCity")).click();
        driver.findElement(By.cssSelector(".react-autosuggest__input")).sendKeys("Newark");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[text()='Newark, United States']")).click();

        driver.findElement(By.cssSelector(".searchToCity")).click();
        driver.findElement(By.cssSelector(".react-autosuggest__input")).sendKeys("Los Angeles");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[text()='Los Angeles, United States']")).click();

        driver.findElement(By.cssSelector(".DayPicker-NavButton--next")).click();
        driver.findElement(By.cssSelector(".DayPicker-Month:nth-child(2) .DayPicker-Week:nth-child(2) > .DayPicker-Day:nth-child(7) > .dateInnerCell")).click();

        // Step 2: Click search and save flight data
        // TODO figure out why webdriver is not allowed to view search results
        driver.findElement(By.cssSelector(".primaryBtn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElement(By.id("left-side--wrapper")).isDisplayed());
        sleep(5);

//        driver.findElement(By.cssSelector("#fli_list_item0 > div:nth-child(2) .dept-options-section")).click();
//        driver.findElement(By.id("section--wrapper")).click();
//        driver.findElement(By.cssSelector("#fli_list_item1 > div:nth-child(2) .dept-options-section")).click();
    }

}
