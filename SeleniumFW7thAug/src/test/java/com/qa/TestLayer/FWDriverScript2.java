package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.PageLayer.basicControls;
import com.qa.PageLayer.dropdownElements;
import com.qa.TestBase.TestBase;

public class FWDriverScript2 extends TestBase {
	
	
	
	@Test(priority=1)
	public void validateSingleSelectionDropdown_TC01() {
		
		try {
	
			dropdownElements dde=new dropdownElements(driver);
			dde.singleSelectionDropdown();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	@Test(priority=2)
	public void validateMultiSelectionDropdown_TC02() {
		
		try {
	
			dropdownElements dde=new dropdownElements(driver);
			dde.MultiSelectionDropdown();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	

}
