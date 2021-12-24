package com.sheets;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelNew.project.BaseClass;

public class AdacCancel extends BaseClass {
	
	public AdacCancel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='my_itinerary']")
	private WebElement btnlogin;
	
	@FindBy(xpath="//input[@id='order_id_text']")
	private WebElement datatxtorderid;
	
	@FindBy(xpath="//input[@id='search_hotel_id']")
	private WebElement datago;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement databtncancel;
	
	@FindBy(xpath="//label[@id='search_result_error']")
	private WebElement dataresult;

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public WebElement getDatatxtorderid() {
		return datatxtorderid;
	}

	public WebElement getDatago() {
		return datago;
	}

	public WebElement getDatabtncancel() {
		return databtncancel;
	}

	public WebElement getDataresult() {
		return dataresult;
	}
	
	public void cancelBooking(String orderno) throws Exception {
	click(btnlogin);
	type(getDatatxtorderid(), orderno);
	click(datago);
	Thread.sleep(2000);
	click(databtncancel);
	alertSwtichToAccept();
	String msg=getDataresult().getText();
	System.out.println(msg);
	Assert.assertEquals(msg, "The booking has been cancelled.");
	
	
	
	
	
	
	}
	

}
