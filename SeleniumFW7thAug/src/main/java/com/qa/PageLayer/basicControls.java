package com.qa.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class basicControls extends TestBase{
	
	
	//Define objects using locator
	//3 different ways
	
	WebDriver rdriver;
	
	//1st way
//	String txtfirstName="//input[@id='firstName']";
//	String txtlastName= "//input[@id='lastName']";
//	String rbtnGender="//input[@id='femalerb']";
//	String chkBoxLanguage="//input[@id='chinesechbx']";
//	String txtEmailId="//input[@id='email']";
//	String btnClear="//button[@id='clearbtn']";
//	String txtPassword="//input[@id='password']";
//	String linkTxtLin="//a[@id='navigateHome']";
	
	//2nd way
//	By txtfirstName=By.xpath("//input[@id='firstName']");
//	By txtlastName=By.xpath("//input[@id='lastName']");
//	By rbtnGender= By.xpath("//input[@id='femalerb']");
//	By chkBoxLanguage= By.xpath("//input[@id='chinesechbx']");
//	By txtEmailId= By.xpath("//input[@id='email']");
//	By btnClear= By.xpath("//button[@id='clearbtn']");
//	By txtPassword= By.xpath("//input[@id='password']");
//	By linkTxtLin= By.xpath("//a[@id='navigateHome']");
	
	//3rd way
	@FindBy (xpath="//input[@id='firstName']")
	WebElement txtfirstName;
	
	@FindBy (xpath="//input[@id='lastName']")
	WebElement txtlastName;
	

	@FindBy (xpath="//input[@id='femalerb']")
	WebElement rbtnGender;
	
	@FindBy (xpath="//input[@id='chinesechbx']")
	WebElement chkBoxLanguage;
	
	@FindBy (xpath="//input[@id='email']")
	WebElement txtEmailId;
	
	@FindBy (xpath="//button[@id='clearbtn']")
	WebElement btnClear;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy (xpath="//a[@id='navigateHome']")
	WebElement linkTxtLin;
	
	@FindBy (xpath="//button[@id='registerbtn']")
	WebElement btnRegister;
	
	public basicControls(WebDriver ldriver){
		
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void fillForm(String firstName, String lastName, String emailID, String password) {
		try {
			
			txtfirstName.sendKeys(firstName);
			txtlastName.sendKeys(lastName);
			rbtnGender.click();
			chkBoxLanguage.click();
			txtEmailId.sendKeys(emailID);
			txtPassword.sendKeys(password);
			Thread.sleep(3000);
			screenshot(driver, "testdataScreen");
			btnClear.click();
			log.info("form file are success");
			screenshot(driver, "testdataScreenClear");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void linkTextField()	{
		
		try {
			
			linkTxtLin.click();
			log.info("form file are success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void fillFormRegister(String firstName, String lastName, String emailID, String password) {
		try {
			
			txtfirstName.sendKeys(firstName);
			txtlastName.sendKeys(lastName);
			rbtnGender.click();
			chkBoxLanguage.click();
			txtEmailId.sendKeys(emailID);
			txtPassword.sendKeys(password);
			Thread.sleep(3000);
			screenshot(driver, "testdataScreen");
			btnRegister.click();
			log.info("form file are success");
			screenshot(driver, "testdataScreenClear");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

}
