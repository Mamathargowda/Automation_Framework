package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String readExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/example.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String excelData = cell.getStringCellValue();
		return excelData;
	
	}
	
public String readFormattedExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/example.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		Sheet sheet1 = wb1.getSheet(sheetName);
		Row row1 = sheet1.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String excelData1 = format.formatCellValue(cell1);
		return excelData1;
	
	}

	public Object[][] readExcelDataForDataProvider(String sheetname) throws Throwable {
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/example.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet1 = book.getSheet(sheetname);
		int lastRow = sheet1.getLastRowNum() + 1;
		Row lastCell = sheet1.getRow(0);
		return null;
		
	}

}
