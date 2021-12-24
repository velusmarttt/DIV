package com.browser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import ExcelNew.project.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launchedge extends BaseClass {
	@Parameters({"Browser"})
	@Test
	private void login(String name) {
		
		if (name.equals("Chrome Browser")) {
		getDriver();
		driver.get("https://www.facebook.com/");
		}
		if(name.equals("firefoxBrowser")) {
			getDriver1();
			driver.get("https://www.facebook.com/");
		}
		if(name.equals("edgeBrowser")) {
			getDriver2();
			driver.get("https://www.facebook.com/");
			}
		
		
	
	}

}
