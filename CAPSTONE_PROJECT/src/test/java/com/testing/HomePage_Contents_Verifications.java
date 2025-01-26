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

public class HomePage_Contents_Verifications {

    WebDriver driver;
    WebDriverWait wait;

    // Locators as constants for better maintainability
    private static final String LOGO_XPATH = "//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/a/img[1]";
    private static final String SEARCHBOX_XPATH = "//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[1]/label/input";
    private static final String SECTIONS_XPATH = "//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[2]";
    private static final String SLIDE_IMAGE_SECTION_XPATH = "//*[@id=\"rev_slider_1_1\"]/rs-arrow[2]";
    private static final String ICONS_SECTION_XPATH = "//*[@id=\"post-10\"]/div/div[1]";
    private static final String ABOUT_COMPANY_XPATH = "//*[@id=\"post-10\"]/div/div[2]";
    private static final String INFO_SECTION_XPATH = "//*[@id=\"post-10\"]/div/div[3]";
    private static final String KEYPARTNER_SECTION_XPATH = "//*[@id=\"post-10\"]/div/div[4]";
    private static final String CONTACT_SECTION_XPATH = "//*[@id=\"wrapper\"]/div[3]/footer[1]";
    private static final String FOOTER_ID = "footer";
    private static final String COOKIE_SECTION_CLASS = "cc-message";

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
    @Step("Step 1: HomePage_Title_Verification")
    public void HomePage_Title_Verification() {
        String actualTitle = "Home - West Florida Area Health Education Center, Inc";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "The Title is not matched with the actual!");
    }

    @Test(priority = 2)
    @Step("Step 2: HomePage_Url_Verification")
    public void HomePage_Url_Verification() {
        String actualUrl = "https://westfloridaahec.org/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "The URL is not matched with the actual!");
    }

    @Test(priority = 3)
    @Step("Step 3: HomePage_Website_Logo_Verification")
    public void HomePage_Website_Logo_Verification() {
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGO_XPATH)));
        Assert.assertTrue(logo.isDisplayed(), "The logo is not displayed on the website!");
    }

    @Test(priority = 4)
    @Step("Step 4: HomePage_Searchbox_Verification")
    public void HomePage_Searchbox_Verification() {
        WebElement searchbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCHBOX_XPATH)));
        Assert.assertTrue(searchbox.isDisplayed(), "The searchbox is not displayed on the website!");
    }

    @Test(priority = 5)
    @Step("Step 5: HomePage_Sections_Verification")
    public void HomePage_Sections_Verification() {
        WebElement sections = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SECTIONS_XPATH)));
        Assert.assertTrue(sections.isDisplayed(), "The Sections are not displayed on the website!");
    }

    @Test(priority = 6)
    @Step("Step 6: HomePage_slide_image_section_Verification")
    public void HomePage_slide_image_section_Verification() {
        WebElement slideImageSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SLIDE_IMAGE_SECTION_XPATH)));
        Assert.assertTrue(slideImageSection.isDisplayed(), "The slide image section is not displayed on the website!");
    }

    @Test(priority = 7)
    @Step("Step 7: HomePage_icons_section_Verification")
    public void HomePage_icons_section_Verification() {
        WebElement iconsSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ICONS_SECTION_XPATH)));
        Assert.assertTrue(iconsSection.isDisplayed(), "The icons section is not displayed on the website!");
    }

    @Test(priority = 8)
    @Step("Step 8: HomePage_about_company_section_Verification")
    public void HomePage_about_company_section_Verification() {
        WebElement aboutCompany = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ABOUT_COMPANY_XPATH)));
        Assert.assertTrue(aboutCompany.isDisplayed(), "The about company section is not displayed on the website!");
    }

    @Test(priority = 9)
    @Step("Step 9: HomePage_info_section_Verification")
    public void HomePage_info_section_Verification() {
        WebElement infoSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(INFO_SECTION_XPATH)));
        Assert.assertTrue(infoSection.isDisplayed(), "The info section is not displayed on the website!");
    }

    @Test(priority = 10)
    @Step("Step 10: HomePage_keypartner_section_Verification")
    public void HomePage_keypartner_section_Verification() {
        WebElement keypartnerSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(KEYPARTNER_SECTION_XPATH)));
        Assert.assertTrue(keypartnerSection.isDisplayed(), "The key partner section is not displayed on the website!");
    }

    @Test(priority = 11)
    @Step("Step 11: HomePage_contact_section_Verification")
    public void HomePage_contact_section_Verification() {
        WebElement contactSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_SECTION_XPATH)));
        Assert.assertTrue(contactSection.isDisplayed(), "The contact section is not displayed on the website!");
    }

    @Test(priority = 12)
    @Step("Step 12: HomePage_footer_section_Verification")
    public void HomePage_footer_section_Verification() {
        WebElement footerSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(FOOTER_ID)));
        Assert.assertTrue(footerSection.isDisplayed(), "The footer section is not displayed on the website!");
    }

    @Test(priority = 13)
    @Step("Step 13: HomePage_Title_Verification")
    public void HomePage_cookie_section_Verification() {
        WebElement cookieSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(COOKIE_SECTION_CLASS)));
        Assert.assertTrue(cookieSection.isDisplayed(), "The cookie section is not displayed on the website!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
