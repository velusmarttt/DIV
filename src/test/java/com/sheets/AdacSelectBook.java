package com.sheets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelNew.project.BaseClass;
import ExcelNew.project.LibGlobal;

public class AdacSelectBook extends BaseClass{
	
	public AdacSelectBook() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement btnsubmit;
	
	@FindBy(id="continue")
	private WebElement btnLogin;

	public WebElement getBtnsubmit() {
		return btnsubmit;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void selectHotel() {
		
		click(getBtnsubmit());
		click(getBtnLogin());
		
	}
	
	 
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
