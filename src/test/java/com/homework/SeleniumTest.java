package com.homework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

// A class for functionality that should be available to each test
public class SeleniumTest {
    WebDriver driver;
    String openLinkNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);

    @BeforeTest(enabled = false)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\Pills\\seleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "D:\\Users\\Pills\\seleniumDrivers\\geckodriver.exe");
//        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
