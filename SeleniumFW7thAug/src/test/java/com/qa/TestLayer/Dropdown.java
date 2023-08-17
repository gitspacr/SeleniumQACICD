package com.qa.TestLayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		//Basic Controls
		//Text, buttons, radio btn, checkbox, links,dropdown
		
		//handle Textbox
		String browser = "Chrome";
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");//200
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//handle dropdown - Single selection dropdown
		WebElement ele=driver.findElement(By.xpath("//select[@id='course']"));
		System.out.println(ele.isDisplayed());
		Select slctCourse=new Select(ele);
		List<WebElement> listEle =slctCourse.getOptions();
		System.out.println(listEle.size());
		for (WebElement eleVal : listEle) {
			String txtVal = eleVal.getText();
			System.out.println(txtVal);
			
		}
		slctCourse.selectByIndex(2);
		Thread.sleep(3000);
		slctCourse.selectByValue("js");
		Thread.sleep(3000);
		slctCourse.selectByVisibleText("Python");
		String val=slctCourse.getFirstSelectedOption().getText();
		System.out.println(val);
		Thread.sleep(3000);
		driver.close();
		
		
		

	}

}
