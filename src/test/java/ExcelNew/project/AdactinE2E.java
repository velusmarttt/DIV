package ExcelNew.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class AdactinE2E {
	static LibGlobal global=new LibGlobal();
	static Map<String, String> data=new HashMap<String, String>();
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
	static String orderno="";
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		driver=global.getDriver();
		global.maximize();
		global.loadUrl("https://adactinhotelapp.com/");
		ExcelOperationRead();
		login();
		searchHotel();
		selectHotel();
		bookAHotel();
		Thread.sleep(7000);
		getorderID();
		global.quit();
		ExcelOperationWrite();
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
}
