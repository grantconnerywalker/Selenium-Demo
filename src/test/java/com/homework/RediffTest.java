package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RediffTest extends SeleniumTest {

    @Test
    public void rediffTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\Pills\\seleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Step 0: navigate to page
        driver.get("https://www.rediff.com/");

        // Step 1: Navigate to shopping page and print categories
        driver.findElement(By.className("shopicon")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> popularCategories = driver.findElements(By.xpath("//div[@id='popular_cat']/h3"));

        // Popping off last 2 elements of the list they are not actual categories
        popularCategories.remove(popularCategories.size()-1);
        popularCategories.remove(popularCategories.size()-1);

        System.out.println("Categories: ");
        popularCategories.forEach(category -> {
            System.out.println(category.getText());
        });

        // Step 2: Open each category in new tab, print the product types
        popularCategories.forEach(category -> {
            String categoryName = category.getText();

            category.findElement(By.linkText(categoryName)).sendKeys(openLinkNewTab);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            WebElement showMore = driver.findElement(By.xpath("//img[@title='show']"));
            if (showMore.isDisplayed()) {
                showMore.click();
            }
            List<WebElement> productsInCategory = driver.findElements(By.cssSelector(".catFilterWrapper > a"));
            System.out.println("\n" + "Current Category: " + categoryName);
            productsInCategory.forEach(product -> {
                System.out.println(product.getText());
            });

            driver.close();
            driver.switchTo().window(tabs.get(0));
        });

    }

}
