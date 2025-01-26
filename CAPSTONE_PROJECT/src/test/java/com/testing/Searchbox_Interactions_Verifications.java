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

public class Searchbox_Interactions_Verifications {

    WebDriver driver;
    WebDriverWait wait;

    // Locators as constants for better maintainability
    private static final String SEARCHBOX_XPATH = "//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[1]/label/input";
    private static final String SEARCHBOX_BUTTON_CSS = "input[type='submit']";

    // Implemented the Cross browsing
    
    @BeforeClass
    @Step("Step : Opening the browser")
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
    @Step("Step 1: Searchbox_Displayed")
    public void Searchbox_Displayed() {
        WebElement searchbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCHBOX_XPATH)));
        Assert.assertTrue(searchbox.isDisplayed(), "The searchbox is not displayed on the website!");
    }
    
    @Test(priority = 2)
    @Step("Step 1: Searchbox_input_text_Verification")
    public void Searchbox_input_text_Verification() {
        WebElement searchbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCHBOX_XPATH)));
        searchbox1.sendKeys("Doctor");
        Assert.assertTrue(searchbox1.getDomProperty("value").contentEquals("Doctor"), "The searchbox is not matched");  
    }
    
    @Test(priority = 3)
    @Step("Step 1: Searchbox_button_Verification")
    public void Searchbox_button_Verification() {
    	String actualUrl = "https://westfloridaahec.org/";
        WebElement searchbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCHBOX_XPATH)));
        searchbox1.clear();
        searchbox1.sendKeys("Selenium");
        Assert.assertTrue(searchbox1.getDomProperty("value").contentEquals("Selenium"), "The searchbox is not matched");  
        WebElement searchbox_button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SEARCHBOX_BUTTON_CSS)));
        searchbox_button.click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertTrue(!actualUrl.equals(expectedUrl), "The searchbox is not matched");  
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

