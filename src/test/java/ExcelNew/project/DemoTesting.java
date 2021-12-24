package ExcelNew.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTesting {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		String path="F:\\velu smarttt\\Workspace\\project\\Excel\\Test (1).xlsx";
		File file=new File(path);
		FileInputStream stream = new FileInputStream(file);
		//create the workbook 
		Workbook workbook=new XSSFWorkbook(stream);
		//get the sheet name
		Sheet sheet=workbook.getSheet("Sheet1");
		
		
		//iterate the cells
		for (int i = 0; i< sheet.getPhysicalNumberOfRows() ; i++) {
		//get the each row
		Row row1 = sheet.getRow(i);
		//Iterate the cells
		for (int j = 0; j < row1.getPhysicalNumberOfCells(); j++) {
			//get the each cell
			Cell cell2 = row1.getCell(j);
			//print the cell value
			System.out.println(cell2);
		}

	}
	}
	
}
