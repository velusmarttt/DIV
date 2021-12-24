package com.sheets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelNew.project.BaseClass;
import ExcelNew.project.LibGlobal;

public class AdacBookAHotel extends BaseClass{
	public AdacBookAHotel() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first_name")
	private WebElement datafirstname;
	
	@FindBy(id="last_name")
	private WebElement dataLastName;
	
	 @FindBy(id="address")
	 private WebElement dataBillingAddress;
	 
	 @FindBy(id="cc_num")
	 private WebElement dataCreditCardNo;
	 
	 @FindBy(id="cc_type")
	 private WebElement dataCreditCardType;
	 
	 @FindBy(id="cc_exp_month")
	 private WebElement dataExpiryMonth;
	 
	 @FindBy(id="cc_exp_year")
	 private WebElement dataExpiryYear;
	  
	 @FindBy(id="cc_cvv")
	 private WebElement dataCvvNumber;
	
	 @FindBy(id="book_now")
	 private WebElement dataLogin;
	 
	 @FindBy(id="order_no")
	 private WebElement dataorderno;
	 

	public WebElement getDatafirstname() {
		return datafirstname;
	}

	public WebElement getDataLastName() {
		return dataLastName;
	}

	public WebElement getDataBillingAddress() {
		return dataBillingAddress;
	}

	public WebElement getDataCreditCardNo() {
		return dataCreditCardNo;
	}

	public WebElement getDataCreditCardType() {
		return dataCreditCardType;
	}

	public WebElement getDataExpiryMonth() {
		return dataExpiryMonth;
	}

	public WebElement getDataExpiryYear() {
		return dataExpiryYear;
	}

	public WebElement getDataCvvNumber() {
		return dataCvvNumber;
	}

	public WebElement getDataLogin() {
		return dataLogin;
	}
	public WebElement getorderno() {
		return dataorderno;
	}

	public String bookAHotel(String firstname,String LastName,String BillingAddress,String CreditCardNo,String CreditCardType,String ExpiryMonth,String ExpiryYear,String cvvNumber) throws Exception{
		PageFactory.initElements(driver, this);
		type(getDatafirstname(),firstname);
		type(getDataLastName(),LastName);
		type(getDataBillingAddress(),BillingAddress);
		type(getDataCreditCardNo(),CreditCardNo);
		type(getDataCreditCardType(),CreditCardType);
		type(getDataExpiryMonth(),ExpiryMonth);
		selectOptionsByText(getDataExpiryYear(),ExpiryYear);
		type(getDataCvvNumber(),cvvNumber);
		click(getDataLogin());
		Thread.sleep(5000);
	String attribute = getAttribute(getorderno(),"value");
	System.out.println(attribute);
		return attribute;
	}		
	}

