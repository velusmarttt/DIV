package ExcelNew.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelpractice {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	String path="F:\\velu smarttt\\Workspace\\project\\src\\test\\java\\resources\\Excels\\Test (1) 1.xlsx";
	File file=new File(path);
	FileInputStream stream=new FileInputStream(file);
	Workbook workbook=new XSSFWorkbook(stream);
	//call the sheet
	Sheet sheet = workbook.getSheet("sheet1");
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		
	//get row
	Row row = sheet.getRow(i);
	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

	//get cell
	Cell cell = row.getCell(j);
	int cellType = cell.getCellType();
	if(cellType==1){
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
	}
	if (cellType==0) {
		if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
			String data = format.format(dateCellValue);
			System.out.println(data);
		} else {
			double d = cell.getNumericCellValue();
			long l=(long) d;
			String valueOf = String.valueOf(l);
			System.out.println(valueOf);
			
		}
	}
	}
	}
	

	}

}
