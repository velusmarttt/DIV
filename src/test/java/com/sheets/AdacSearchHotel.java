package com.sheets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ExcelNew.project.BaseClass;
import ExcelNew.project.LibGlobal;

public class AdacSearchHotel extends BaseClass {
	public AdacSearchHotel() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="location")
	private WebElement dataLocation;
	
	@FindBy(id="hotels")
	private WebElement dataHotels;
	
	 @FindBy(id="room_type")
	 private WebElement dataRoomType;
	 
	 @FindBy(id="room_nos")
	 private WebElement dataNumberofRooms;
	 
	 @FindBy(id="datepick_in")
	 private WebElement dataCheckInDate ;
	 
	 @FindBy(id="datepick_out")
	 private WebElement dataCheckOutDate;
	 
	 @FindBy(id="adult_room")
	 private WebElement dataAdultsPerRoom;
	  
	 @FindBy(id="child_room")
	 private WebElement dataChildrenPerRoom;
	
	 @FindBy(id="Submit")
	 private WebElement dataLogin;
	 

	 public WebElement getDataLocation() {
		return dataLocation;
	}

	public WebElement getDataHotels() {
		return dataHotels;
	}

	public WebElement getDataRoomType() {
		return dataRoomType;
	}

	public WebElement getDataNumberofRooms() {
		return dataNumberofRooms;
	}

	public WebElement getDataCheckInDate() {
		return dataCheckInDate;
	}

	public WebElement getDataCheckOutDate() {
		return dataCheckOutDate;
	}

	public WebElement getDataAdultsPerRoom() {
		return dataAdultsPerRoom;
	}

	public WebElement getDataChildrenPerRoom() {
		return dataChildrenPerRoom;
	}

	public WebElement getDataLogin() {
		return dataLogin;
	
}
	public void searchHotel(String Location,String Hotels, String roomtype,String Numberofrooms,String checkIndate,String checkoutdate,String Adultsperroom,String childrenperroom) {
		
	selectOptionsByText(getDataLocation(),Location);
	selectOptionsByText(getDataHotels(), Hotels);
	selectOptionsByText(getDataRoomType(),roomtype);
	selectOptionsByText(getDataNumberofRooms(),Numberofrooms);
	type(getDataCheckInDate(),checkIndate);
	type(getDataCheckOutDate(),checkoutdate);
	selectOptionsByText(getDataAdultsPerRoom(),Adultsperroom);
	selectOptionsByText(getDataChildrenPerRoom(),childrenperroom);
	click(getDataLogin());
	}
}











	

