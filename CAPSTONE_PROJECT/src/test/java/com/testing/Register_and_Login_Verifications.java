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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Step;

public class Register_and_Login_Verifications {
	WebDriver driver;
	WebDriverWait wait;

	// Locators as constants for better maintainability
	private static final String Myaccount_section_xpath = "//*[@id=\"menu-main-menu\"]/li[8]/a/span[1]";
	
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
	 @Step("Step 1: Register_acc_section")
	    public void Register_acc_section() {
	    	 	WebElement accLink = driver.findElement(By.xpath(Myaccount_section_xpath));
	    	 	accLink.click();
	    	 	String Actual_url =driver.getCurrentUrl();
	    		String Expected_url="https://westfloridaahec.org/my-account/";
	    		if(Actual_url.contentEquals(Expected_url))
	    		{	
	    			WebElement username_regirster = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reg_username")));
	    			username_regirster.sendKeys("UserVan");
	    			WebElement email_regirster = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
	    			email_regirster.sendKeys("Van.sai@gmail.com");
	    			WebElement password_regirster = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"reg_password\"]")));
	    			password_regirster.sendKeys("Van@143655");
	    			WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")));
	    			register.click();
	    			WebElement verifey_register = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div[1]/span[1]")));
	    			if(verifey_register.getText().contentEquals("Hello UserVan"))
	    			{
	    				System.out.println("Verified registry");
	    			}
	    			WebElement register_logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[7]/a")));
	    			register_logout.click();
	    		}	    		
		    		
	  }
	 
	 @Test(priority = 2)
	 @Step("Step 2: Login_acc_section")
	    public void Login_acc_section() {
	    	 	WebElement accLink = driver.findElement(By.xpath(Myaccount_section_xpath));
	    	 	accLink.click();
	    	 	String Actual_url =driver.getCurrentUrl();
	    		String Expected_url="https://westfloridaahec.org/my-account/";
	    		if(Actual_url.contentEquals(Expected_url))
	    		{	
	    			WebElement username_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
	    			username_login.sendKeys("UserJohn");
	    			WebElement password_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
	    			password_login.sendKeys("John@143655");
	    			WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")));
	    			login.click();
	    			}
		    		WebElement verifey_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div[1]/span[1]")));
	    			
		    		if(verifey_login.getText().contentEquals("Hello UserJohn"))
	    			{
	    				System.out.println("Verified login");
	    			}
		    		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[7]/a")));
		    		logout.click();
		    	
	    		}
	 @Test(priority = 3)
	 @Step("Step 3: Reset_password_section")
	    public void Reset_password_section() {
	    	 	WebElement accLink = driver.findElement(By.xpath(Myaccount_section_xpath));
	    	 	accLink.click();
	    	 	String Actual_url =driver.getCurrentUrl();
	    		String Expected_url="https://westfloridaahec.org/my-account/";
	    		if(Actual_url.contentEquals(Expected_url))
	    		{	
	    			//Recover over mail
		    		WebElement forgot_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/a")));
		    		forgot_pass.click();
		    		WebElement username_login_forgot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"user_login\"]")));
		    		username_login_forgot.sendKeys("UserJohn");
		    		WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/form/p[3]/button")));
		    		reset.click();
		    		WebElement reset_msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-381\"]/div/div/div/div")));
		    		System.out.println(reset_msg.getText());
		    				    		
	    		}
	 }
	 
	 @Test(priority = 4)
	 @Step("Step 4: Login_and_Reset_section")
	    public void Login_and_Reset_section() {
	    	 	WebElement accLink = driver.findElement(By.xpath(Myaccount_section_xpath));
	    	 	accLink.click();
	    	 	String Actual_url =driver.getCurrentUrl();
	    		String Expected_url="https://westfloridaahec.org/my-account/";
	    		if(Actual_url.contentEquals(Expected_url))
	    		{	
	    			WebElement username_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
	    			username_login.sendKeys("UserJohn");
	    			WebElement password_login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
	    			password_login.sendKeys("John@143655");
	    			WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")));
	    			login.click();
	    			WebElement Account_details = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[6]/a")));
	    			Account_details.click();
	    			WebElement password_login_current = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password_current\"]")));
	    			password_login_current.sendKeys("John@143655");
	    			WebElement password_login_new = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password_1\"]")));
	    			password_login_new.sendKeys("John@655143");
	    			WebElement password_login_confirm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password_2\"]")));
	    			password_login_confirm.sendKeys("John@655143");
	    			WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-381\"]/div/div/div[2]/form/p[5]/button")));
	    			submit.click();
		    				    		
	    		}
	 }
	    	 	
	    
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
