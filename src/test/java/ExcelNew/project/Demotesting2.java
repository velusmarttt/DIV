package ExcelNew.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demotesting2 {
	public static void main(String[] args) throws IOException {
		String path=("F:\\velu smarttt\\Workspace\\project\\Excel\\Gokul.xlsx");
		File file=new File(path);
		FileInputStream stream = new FileInputStream(file);
		//create the workbook 
		Workbook workbook=new XSSFWorkbook(stream);
		//get the sheet name
		Sheet sheet=workbook.getSheet("Sheet1");
		for (int i = 0; i< sheet.getPhysicalNumberOfRows() ; i++) {
			//get the each row
			Row row = sheet.getRow(i);
			//Iterate the cells
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				//get the each cell
				Cell cell = row.getCell(j);
			  int cellType = cell.getCellType();
			 if(cellType==1) {
			String data = cell.getStringCellValue();	 
			System.out.println(data);	
			 }
			 if(cellType==0) {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yy");
				String data = dateformat.format(date);
				System.out.println(data);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l=(long)numericCellValue;
				String data=String.valueOf(l);
				System.out.println(data);
				
				
				
			}
				 
			 }
		
	}

}
	}
}
