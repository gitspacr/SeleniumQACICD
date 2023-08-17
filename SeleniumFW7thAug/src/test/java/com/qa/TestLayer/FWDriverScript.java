package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.PageLayer.basicControls;
import com.qa.TestBase.TestBase;
import com.qa.TestData.DataDriventest;

public class FWDriverScript extends TestBase {
	
	
	
//	@Test(dataProvider="passDataFromExcel", dataProviderClass=DataDriventest.class)
	public void validateFormfile_TC01(String FirstName, String LastName, String emailID, String password) {
		
		try {
	
			basicControls bc=new basicControls(driver);
			bc.fillForm(FirstName,LastName,emailID,password);
			screenshot(driver, "formFileScreen");
			log.info("validate form fill success");
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
//	@Test
	public void validateLink_TC02() {
		
		try {
	
			basicControls bc=new basicControls(driver);
			bc.linkTextField();
			screenshot(driver, "LinkText");
			log.info("validate linktext success");
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	
	@Test(dataProvider="passDataFromExcel", dataProviderClass=DataDriventest.class)
	public void validateTitle_TC03(String FirstName, String LastName, String emailID, String password) {
		
		try {
	
			basicControls bc=new basicControls(driver);
			bc.fillFormRegister(FirstName,LastName,emailID,password);
			screenshot(driver, "Registered");
			log.info("validate register page is success");
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	

}
