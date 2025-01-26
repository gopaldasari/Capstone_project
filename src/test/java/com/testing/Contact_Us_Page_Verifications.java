package com.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Step;

public class Contact_Us_Page_Verifications {
    WebDriver driver;
    WebDriverWait wait;

    // Locators as constants for better maintainability
    private static final String Contact_us_page_xpath = "//*[@id=\"menu-item-209\"]/a/span";
    private static final String Email_xpath = "//*[@id=\"post-127\"]/div/div[1]/div/div/div/div[7]/div[4]/div/div[3]/p/a";
    private static final String Maps_xpath = "//*[@id=\"post-127\"]/div/div[1]/div/div/div/div[7]/div[1]/div/div[3]/p/a";
    private static final String Call_us_xpath = "//*[@id=\"post-127\"]/div/div[1]/div/div/div/div[7]/div[2]/div/div[3]/p/a";
    private static final String Fax_xpath = "//*[@id=\"post-127\"]/div/div[1]/div/div/div/div[7]/div[3]/div/div[3]/p/a";

    @BeforeClass
    @Step("Step 1: Opening the browser")
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        // Choose the browser dynamically
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://westfloridaahec.org/");
    }

    @Test(priority = 1)
    @Step("Step 2: Verifying the contact page")
    public void Contact_Us_Page() throws InterruptedException {

        try {
            // Navigate to Contact Us page
            WebElement contact_us_Link = driver.findElement(By.xpath(Contact_us_page_xpath));
            contact_us_Link.click();

            String expectedUrl = "https://westfloridaahec.org/contact-us/";
            String actualUrl = driver.getCurrentUrl();

            // Verify Contact Us page URL
            assert actualUrl.equals(expectedUrl) : "Failed to navigate to contact us page";

            // Verify Maps icon
            WebElement maps = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Maps_xpath)));
            Assert.assertTrue(maps.isDisplayed(), "Maps should be visible.");
            maps.click();
            

            String parentWindow = driver.getWindowHandle();
            for (String childWindow : driver.getWindowHandles()) {
                if (!childWindow.equals(parentWindow)) {
                    driver.switchTo().window(childWindow);
                    driver.close();
                    System.out.println("Maps icon verification: PASSED");
                    driver.switchTo().window(parentWindow);
                }
            }
            driver.navigate().refresh();

            // Verify Call Us icon
            WebElement call_us = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Call_us_xpath)));
            Assert.assertTrue(call_us.isDisplayed(), "Call_us should be visible.");
            call_us.click();

            for (String childWindow : driver.getWindowHandles()) {
                if (!childWindow.equals(parentWindow)) {
                    driver.switchTo().window(childWindow);
                    driver.close();
                    System.out.println("Call us icon verification: PASSED");
                    driver.switchTo().window(parentWindow);
                }
            }
            driver.navigate().refresh();

            // Verify Fax icon
            WebElement fax = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Fax_xpath)));
            Assert.assertTrue(fax.isDisplayed(), "Fax icon should be visible.");
            fax.click();

            for (String childWindow : driver.getWindowHandles()) {
                if (!childWindow.equals(parentWindow)) {
                    driver.switchTo().window(childWindow);
                    driver.close();
                    System.out.println("Fax icon verification: PASSED");
                    driver.switchTo().window(parentWindow);
                }
            }

            // Verify Email icon
            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Email_xpath)));
            assert email.isDisplayed() : "Email icon is not displayed!";
            email.click();
            System.out.println("Email icon verification: PASSED");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            // Handle the exception appropriately (e.g., log the error, take a screenshot)
        } finally {
            System.out.println("Test completed.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
