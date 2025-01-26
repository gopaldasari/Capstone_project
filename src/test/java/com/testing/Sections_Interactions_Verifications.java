package com.testing;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Step;

public class Sections_Interactions_Verifications {
    WebDriver driver;
    WebDriverWait wait;

    // Locators as constants for better maintainability
    private static final String About_section_xpath = "//*[@id=\"menu-item-616\"]/a/span[1]";
    private static final String Programs_section_xpath = "//*[@id=\"menu-item-264\"]/a/span[1]";
    private static final String servies_section_xpath = "//*[@id=\"menu-item-331\"]/a/span[1]";
    private static final String CPR_section_xpath = "//*[@id=\"menu-item-467\"]/a/span[1]";
    private static final String Myaccount_section_xpath = "//*[@id=\"menu-main-menu\"]/li[8]/a/span[1]";
    private static final String Contact_us_section_xpath = "//*[@id=\"menu-item-209\"]/a/span";
    private static final String News_section_xpath = "//*[@id=\"menu-item-1097\"]/a/span";

    //private static final String HOME_xpath = "//*[@id=\"menu-item-207\"]/a/span";

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
    @Step("Step 1: About_section")
    public void About_section() {
        WebElement aboutLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(About_section_xpath)));
        aboutLink.click();
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id='menu-item-616']/ul/li/a"));
        for (WebElement options : dropdownOptions) {
            String optionText = options.getText();
            System.out.println("Navigating to: " + optionText);
            wait.until(ExpectedConditions.elementToBeClickable(options));
            options.click();
            System.out.println("URL of navigated location:" + driver.getCurrentUrl());
            driver.navigate().back();
            System.out.println("URL after navigation back:" + driver.getCurrentUrl());
            aboutLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(About_section_xpath)));
            aboutLink.click();
        }
    }

    @Test(priority = 2)
    @Step("Step 2: Programs_section")
    public void Programs_section() {
        WebElement programsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Programs_section_xpath)));
        programsLink.click();
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id='menu-item-264']/ul/li/a"));
        for (WebElement options : dropdownOptions) {
            String optionText = options.getText();
            System.out.println("Navigating to: " + optionText);
            wait.until(ExpectedConditions.elementToBeClickable(options));
            options.click();
            System.out.println("URL of navigated location:" + driver.getCurrentUrl());
            driver.navigate().back();
            System.out.println("URL after navigation back:" + driver.getCurrentUrl());
            programsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Programs_section_xpath)));
            programsLink.click();
        }
    }

    @Test(priority = 3)
    @Step("Step 3: Services_section")
    public void Services_section() {
        WebElement servicesLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(servies_section_xpath)));
        servicesLink.click();
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id='menu-item-331']/ul/li/a"));
        for (WebElement options : dropdownOptions) {
            String optionText = options.getText();
            System.out.println("Navigating to: " + optionText);
            wait.until(ExpectedConditions.elementToBeClickable(options));
            options.click();
            System.out.println("URL of navigated location:" + driver.getCurrentUrl());
            driver.navigate().back();
            System.out.println("URL after navigation back:" + driver.getCurrentUrl());
            servicesLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(servies_section_xpath)));
            servicesLink.click();
        }
    }

    @Test(priority = 4)
    @Step("Step 1: CPR_section")
    public void CPR_section() {
        WebElement CPRLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CPR_section_xpath)));
        CPRLink.click();
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id='menu-item-467']/ul/li/a"));
        for (WebElement options : dropdownOptions) {
            String optionText = options.getText();
            System.out.println("Navigating to: " + optionText);
            wait.until(ExpectedConditions.elementToBeClickable(options));
            options.click();
            System.out.println("URL of navigated location:" + driver.getCurrentUrl());
            driver.navigate().back();
            System.out.println("URL after navigation back:" + driver.getCurrentUrl());
            CPRLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CPR_section_xpath)));
            CPRLink.click();
        }
    }

    @Test(priority = 5)
    @Step("Step 5: Contact_section")
    public void Contact_section() {
        WebElement contactLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Contact_us_section_xpath)));
        contactLink.click();
        System.out.println("URL of navigated location:" + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("URL after navigation back:" + driver.getCurrentUrl());
    }

    @Test(priority = 6)
    @Step("Step 6: News_section")
    public void News_section() {
        WebElement NewsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(News_section_xpath)));
        NewsLink.click();
        System.out.println("URL of navigated location:" + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("URL after navigation back:" + driver.getCurrentUrl());
    }

    @Test(priority = 7)
    @Step("Step 7: Myacc_section")
    public void Myacc_section() {
        WebElement accLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Myaccount_section_xpath)));
        accLink.click();
        System.out.println("URL of navigated location:" + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("URL after navigation back:" + driver.getCurrentUrl());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
