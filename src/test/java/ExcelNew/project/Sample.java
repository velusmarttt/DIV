package ExcelNew.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file=new File("F:\\velu smarttt\\Workspace\\project\\src\\test\\java\\resources\\Excels\\MyExcel.xlsx");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement element = driver.findElement(By.id("Skills"));
		Select select=new Select(element);
		//get the all options
		 List<WebElement> list = select.getOptions();
		 List<String> li=new ArrayList<String>();
		 //iterate 
		 for (WebElement data : list) {
			li.add(data.getText());
		}
			driver.quit();
			
			//starting to work in excel
			FileOutputStream stream=new FileOutputStream(file);
			Workbook workbook=new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("sheet10");
				Row row = sheet.createRow(0);
				//create cell
				Cell cell = row.createCell(0);
				cell.setCellValue(li.get(0));
				
	}

}
