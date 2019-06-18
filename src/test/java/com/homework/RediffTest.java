package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RediffTest extends SeleniumTest {

    @Test
    public void rediffTest() {
        driver.get("https://www.rediff.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
