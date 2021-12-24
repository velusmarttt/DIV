package ExcelNew.project;


		
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sheets.AdacSelectBook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	String data;
	public String getData(String sheetName, int  rownum, int cellnum ) throws IOException {
		File file = new File("F:\\velu smarttt\\Workspace\\project\\Excel\\AdactinDataout 8 (1).xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if (cellType==1) {
			data = cell.getStringCellValue();
		}
		if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				data = format.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				data= String.valueOf(l);
			}
		}
		return data;
	}
	public void saveData(String data, String sheetName, int rownum) throws IOException {
		File file = new File("C:\\Users\\gokul\\eclipse-workspace\\FrameWorkClass\\Excel\\Adatin.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		System.out.println(physicalNumberOfCells);
		Cell createCell = row.createCell(row.getPhysicalNumberOfCells());
		createCell.setCellValue(data);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
	}
	public static WebDriver  driver;
	public  static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();	
	}
	public static void getDriver1() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	public static void getDriver2() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	public static  void loadUrl(String url) {
		driver.get(url);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public  static void quit() {
		driver.quit();
	}
	public void close() {
		driver.close();
	}
	public void type(WebElement element,String data) {
		element.sendKeys(data);
	}
	
	public void typeClear(WebElement element) {
		element.clear();
		
	}
	public   void click(WebElement element) {
		element.click();
	}
	public   WebElement findElementById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}
	public   WebElement findElementByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}
	public   WebElement findElementByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}
	public String getEnteredUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public   String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public String getAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	public void selectOptionsByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}
	public void selectOptionsByAttribute(WebElement element,String data ) {
		Select select = new Select(element);
				select.selectByValue(data);
	}
	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void typeJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" +data + "')", element);
	}
	public void clickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public void switchToFrameById(String frameId) {
		driver.switchTo().frame(frameId);
	}
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		
	}
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void tabRefresh() {
		driver.navigate().refresh();
	}
	public String switchToWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public Set<String> getAllWindowId() {
	Set<String> windowHandles = driver.getWindowHandles();
	return windowHandles;
	}
	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void dragAndDrop(WebElement element1, WebElement element2) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2);
	}
	public void robotKeysPress(int KeyEvent) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent);
	}
	public void robotKeysRelease(int KeyEvent) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent);
	}
	
	public void alertSwtichToAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	public static void sleep(int data) throws InterruptedException {
		Thread.sleep(data);
	}
	
}



