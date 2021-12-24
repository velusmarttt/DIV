package com.sheets;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ExcelNew.project.BaseClass;


public class Testngadactin extends BaseClass{
	@BeforeClass
	public void beforeClass() {
	getDriver();
	loadUrl("https://adactinhotelapp.com/");
	maximize();
	}
	

	@AfterClass
	public void afterClass() {
	//quit();
	}
	
//	@BeforeMethod
//	private void beforeMethod() {
//		
//	}
//	@AfterMethod
//	private void afterMethod() {
//		
//		
//		
//	}
	@Test
	public void booking() throws Exception {
	//1.login
		Adaclogin lo=new Adaclogin();
		lo.login("Velusmarttt","monsterboy");
	 
//2.search hotel
	 AdacSearchHotel hotel = new AdacSearchHotel();
	 hotel.searchHotel("London","Hotel Sunshine","Standard","2 - Two","18/12/2021","20/12/2021","1 - One","2 - Two");
	
	 //3.select hotel
	 AdacSelectBook btnsubmit=new  AdacSelectBook();
	 btnsubmit.selectHotel();
	 
	 //4.book a Hotel
	 AdacBookAHotel book=new AdacBookAHotel();
	 book.bookAHotel("venkat","vel","no.56B","4567231557899080","Master Card","January","2022","564");
	 
	 //5.cancel booking
//	 AdacCancel cancel=new AdacCancel();
//	 cancel.cancelBooking();
	 
//	 //6.assert equals or not
//	 String s=cancel.getdataresult();
//	 Assert.assertEquals("The booking has been cancelled.", s);
//	}
	 
	 
	
	 
	

}
}
