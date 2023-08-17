package com.qa.TestLayer;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDriverScript {
	
	
	
static Logger log;
	
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		log=LogManager.getLogger(TestDriverScript.class);
		String browser = "Chrome";
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched successfully");
		} else if (browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("firefox browser launched successfully");
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("edge browser launched successfully");
		}
		
		
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");//200
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test//(enabled=false, dataProvider="passData", dataProviderClass=TestDataMethod.class)
	public static void testNG_TC01(String FirstName, String LastName) throws Exception {
		
		
		
		//Selenium provides locators: id, name, classname, linktext,
		//partiallinktext, tagname,xpath and css selector
		driver.findElement(By.id("firstName")).sendKeys(FirstName);
//		driver.findElement(By.id("firstName")).clear();
//		driver.findElement(By.id("firstName")).sendKeys("Automation");
		driver.findElement(By.name("lName")).sendKeys(LastName);
		driver.findElement(By.id("femalerb")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("clearbtn")).click();
		
		
		
	}
	
	@Test(enabled=false)
	public static void testNG_TC02() throws Exception {
		
		
		
		//Selenium provides locators: id, name, classname, linktext,
		//partiallinktext, tagname,xpath and css selector
		
		driver.findElement(By.partialLinkText("Click here to navigate")).click();
		//Browser navigation commands
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().to("https://www.selenium.dev/");
		driver.navigate().back();
		Thread.sleep(3000);
		driver.close();//current url closing
//		driver.quit();//close all browser
		
	}
	
	@Test(enabled=true)
	public static void testNG_TC03() throws Exception {
		
		String actualValue=driver.getTitle();
		
		String expectedValue ="Basic Controls - H Y R Tutorials";
		Assert.assertEquals(actualValue, expectedValue,"Test case pass");
//		Assert.assertNotEquals(actualValue, expectedValue, "Test cases not equal");
		log.info("title of the page is verified: "+actualValue);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		log.info("closing browser");
	}
	

}
