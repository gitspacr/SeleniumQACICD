package com.qa.PageLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase.TestBase;

public class dropdownElements extends TestBase{
	
	WebDriver rdriver;
	
	
	//3rd way
	@FindBy (xpath="//select[@id='course']")
	WebElement slctCourse;
	
	@FindBy (xpath="//select[@id='ide']")
	WebElement slctIde;
	
	public dropdownElements(WebDriver ldriver){
		
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public void singleSelectionDropdown() {
		
		try {
			//handle dropdown - Single selection dropdown
			WebElement ele=slctCourse;
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
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void MultiSelectionDropdown() {
		
		try {
			//handle dropdown - Multi selection dropdown
			WebElement ele=slctIde;
			System.out.println(ele.isDisplayed());
			Select slctCourse=new Select(ele);
			List<WebElement> listEle =slctCourse.getOptions();
			System.out.println(listEle.size());
			for (WebElement eleVal : listEle) {
				String txtVal = eleVal.getText();
				System.out.println(txtVal);
				
			}
			slctCourse.selectByIndex(0);
			Thread.sleep(3000);
			slctCourse.selectByValue("vs");
			Thread.sleep(3000);
			slctCourse.selectByVisibleText("NetBeans");
			List<WebElement> valList=slctCourse.getAllSelectedOptions();
			System.out.println(valList.size());
			for (WebElement slctdOptions : valList) {
				String txt=slctdOptions.getText();
				System.out.println(txt);
				
			}
			Thread.sleep(3000);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
