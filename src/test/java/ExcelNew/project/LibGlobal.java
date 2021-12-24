package ExcelNew.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	
	static LibGlobal global=new LibGlobal();
	public static Map<String, String> data=new HashMap<String, String>();
	static String path="F:\\velu smarttt\\Workspace\\project\\src\\test\\java\\resources\\Excels\\AdactinData.xlsx";
	static String pathout="F:\\velu smarttt\\Workspace\\project\\src\\test\\java\\resources\\Excels\\AdactinDataout.xlsx";
	static File file;
	static Workbook workbook;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static List<String> keys=new ArrayList<String>();
	static int cellType;
	static int rowcount;
	static int keyscount;
	public static String orderno="";
	
	  private void getdata(String sheet, int row, int cell) throws Exception {
		File file =new File("F:\\\\velu smarttt\\\\Workspace\\\\project\\\\src\\\\test\\\\java\\\\resources\\\\Excels\\\\AdactinData.xlsx");
		FileInputStream stream = new FileInputStream(file);
	

		
		

	}
	
	public static void ExcelOperationRead() throws Exception {
		file=new File(path);
		FileInputStream stream=new FileInputStream(file);
		workbook=new XSSFWorkbook(stream);
		sheet=workbook.getSheet("AdactinData");
		rowcount=sheet.getPhysicalNumberOfRows();
		for(int i=0;i< rowcount;i++) {
			row=sheet.getRow(i);
			//iterate the cells
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				cell=row.getCell(j);
				cellType=cell.getCellType();
			if(i==0) {
			if(cellType==1) {
				keys.add(cell.getStringCellValue());
			}
			else keys.add(""+cell.getNumericCellValue());
			}
			if(i!=0) {
			if(cellType==1) {
				data.put(keys.get(j),cell.getStringCellValue());
			}
			else {
				String s=""+cell.getNumericCellValue();
				if(s.length()<8) {
				s=s.substring(0, s.length()-2);
				}
				data.put(keys.get(j), s);
			}
				
			}
			}
		}
		System.out.println(keys);
		System.out.println(data);
		keyscount=keys.size();
	stream.close();
	}
	public static void ExcelOperationWrite() throws Exception {
		file=new File(pathout);
		FileOutputStream stream=new FileOutputStream(file);
		workbook=new XSSFWorkbook();
		sheet=workbook.createSheet("FinalOutput");
		for(int i=0;i<rowcount;i++) {
			row=sheet.createRow(i);
			for(int j=0;j<keyscount;j++) {
				cell=row.createCell(j);
				if(i==0) {
					cell.setCellValue(keys.get(j));
				}
				if(i!=0) {
					if(j==keyscount-1){
						cell.setCellValue(orderno);
						break;
					}
					cell.setCellValue(data.get(keys.get(j)));
				}
			}
		}
		workbook.write(stream);
		stream.close();
			}
	public static void login() {
		driver.findElement(By.id("username")).sendKeys(data.get("Username"));
		driver.findElement(By.id("password")).sendKeys(data.get("Password"));
		driver.findElement(By.id("login")).click();
	}
	
	public static void searchHotel() {
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
	public static void selectHotel() {
		global.findElementByid("radiobutton_0").click();
		global.findElementByid("continue").click();
	}
	public static void bookAHotel() throws Exception {
		global.findElementByid("first_name").sendKeys(data.get("FirstName"));
		global.findElementByid("last_name").sendKeys(data.get("LastName"));
		global.findElementByid("address").sendKeys(data.get("BillingAddress"));
		global.findElementByid("cc_num").sendKeys(data.get("CreditCardNo"));
		global.selectoptionBytext(global.findElementByid("cc_type"), data.get("CreditCardType"));
		global.selectoptionBytext(global.findElementByid("cc_exp_month"), data.get("ExpiryMonth"));
		global.selectoptionBytext(global.findElementByid("cc_exp_year"), data.get("ExpiryYear"));
		global.findElementByid("cc_cvv").sendKeys(data.get("CvvNumber"));
		global.findElementByid("book_now").click();
	}
	public static void getorderID() {
		orderno=global.findElementByid("order_no").getAttribute("value");
	}
	
	
	  protected static WebDriver driver;

		public static WebDriver getDriver() {
			WebDriverManager.chromedriver().setup();
			return driver=new ChromeDriver();
		}
		public static void loadUrl(String url) {
			driver.get(url);
		}
		public static void maximize() {
			driver.manage().window().maximize();
		}
		public void type(WebElement element,String data) {
			element.sendKeys(data);
		}
		public static void quit() {
			driver.quit();
		}
		public void click(WebElement element) {
			element.click();
		}
		public WebElement findElementByid(String data) {
			WebElement element = driver.findElement(By.id(data));
			return element;
		}
		public WebElement findElementByName(String data) {
			WebElement element = driver.findElement(By.name(data));
			return element;
		}
		public WebElement findElementByxpath(String data) {
			WebElement element = driver.findElement(By.xpath(data));
			return element;
		}
		public  static String getenteredurl() {
			String url = driver.getCurrentUrl();
			return url;
		}
		public String Title() {
			String title = driver.getTitle();
			return title;
		}
		public String getText(WebElement element) {
			String data = element.getText();
			return data;
		}
		public String getAttribute(WebElement element,String attributeName) {
			String data = element.getAttribute(attributeName);
			return data;
		}
		public String getAttribute(WebElement element) {
			String data = element.getAttribute("value");
			return data;
		}
		public static void selectoptionBytext(WebElement element,String data) {
			Select select=new Select(element);
			select.selectByVisibleText(data);
		}
		public void selectoptionByAttribute(WebElement element,String data) {
			Select select=new Select(element);
			select.selectByValue(data);
		}
		public void selectoptionByIndex(WebElement element,int index) {
			Select select=new Select(element);
			select.selectByIndex(index);
		}
		public void alertaccept() {
			driver.switchTo().alert().accept();
		}
		
		
		public void typeJs(WebElement element,String data ) {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value,' '"+data+"')"+element);
		}
		public void SwitchToframeByid(String frameid) {
		driver.switchTo().frame(frameid);
}
		public static String getMethodName() {
		    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		    return ste[3].getMethodName();
		  }
		public static String getClassName() {
		    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		    return ste[3].getClassName();
		  }
		 public static Object executeJavascript(String script, WebDriver driver) {
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    return js.executeScript(script);
			  }
		 protected WebDriver getDriverr() {
			    return driver;
			  }
		 public static void SendKeys(WebElement element,String string) {
			 element.sendKeys(string);
		 }
		 
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}




































































