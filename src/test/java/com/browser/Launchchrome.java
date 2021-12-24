package com.browser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ExcelNew.project.BaseClass;

public class Launchchrome extends BaseClass {
	@Parameters({"Browser"})
	@Test
	private void login(String name) {
		if(name.equals("Chrome Browser")){
			getDriver();
			driver.get("https://www.redbus.in");
		}
		
		if(name.equals("Edge Browser")) {
			getDriver();
			driver.get("https://www.redbus.in/");
				
			}
		if(name.equals("Firefox Browser")) {
			getDriver();
			driver.get("https://www.redbus.in/");
		}
		
		}
	}
	
	


