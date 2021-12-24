package ExcelNew.project;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

	
	public class JunitClass extends LibGlobal{ 
	@BeforeClass
	public static void beforeclass() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		ExcelOperationRead();
	}
	 
	@AfterClass
	public static void afterclass() throws Exception {
		driver.quit();
		ExcelOperationWrite();
	
	}

	@Test
	public void myTest1() {
		driver.findElement(By.id("username")).sendKeys(data.get("Username"));
		driver.findElement(By.id("password")).sendKeys(data.get("Password"));
		driver.findElement(By.id("login")).click();
	}
	@Test
	public void myTest2() {
		WebElement name = driver.findElement(By.id("username_show"));
		String compare = name.getAttribute("value");
		Assert.assertEquals("Hello "+data.get("Username")+"!",compare);
		global.selectoptionBytext(global.findElementByid("location"),data.get("Location"));
		global.selectoptionBytext(global.findElementByid("hotels"), data.get("Hotels"));
		global.selectoptionBytext(global.findElementByid("room_type"), data.get("RoomType"));
		global.selectoptionBytext(global.findElementByid("room_nos"), data.get("NumberOfRooms"));
		global.findElementByid("datepick_in").clear();
		global.findElementByid("datepick_in").sendKeys(data.get("CheckInDate").trim());
		global.findElementByid("datepick_out").clear();
		global.findElementByid("datepick_out").sendKeys(data.get("CheckOutDate").trim());
		global.selectoptionBytext(global.findElementByid("adult_room"), data.get("AdultsPerRoom"));
		global.selectoptionBytext(global.findElementByid("child_room"), data.get("ChildrenPerRoom"));
		global.findElementByid("Submit").click();
		
	}
	@Test
	public void myTest3() {
		global.findElementByid("radiobutton_0").click();
		global.findElementByid("continue").click();
	}
	@Test
	public void myTest4() throws Exception {
		global.findElementByid("first_name").sendKeys(data.get("FirstName"));
		global.findElementByid("last_name").sendKeys(data.get("LastName"));
		global.findElementByid("address").sendKeys(data.get("BillingAddress"));
		global.findElementByid("cc_num").sendKeys(data.get("CreditCardNo"));
		global.selectoptionBytext(global.findElementByid("cc_type"), data.get("CreditCardType"));
		global.selectoptionBytext(global.findElementByid("cc_exp_month"), data.get("ExpiryMonth"));
		global.selectoptionBytext(global.findElementByid("cc_exp_year"), data.get("ExpiryYear"));
		global.findElementByid("cc_cvv").sendKeys(data.get("CvvNumber"));
		global.findElementByid("book_now").click();
		Thread.sleep(5000);
	}
	@Test
	public void myTest5() {
		orderno=global.findElementByid("order_no").getAttribute("value");
		System.out.println(orderno);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	}
