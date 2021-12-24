package com.sheets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelNew.project.BaseClass;
import ExcelNew.project.LibGlobal;

public class Adaclogin extends BaseClass {
	public Adaclogin() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtusername;
	
	@FindBy(id="password")
	private WebElement txtpassword;
	
	 @FindBy(id="login")
	 private WebElement btnlogin;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	 
	 public void login(String username,String password) {
		type(getTxtusername(), username);
		type(getTxtpassword(), password);
		click(getBtnlogin());
	}

}
	