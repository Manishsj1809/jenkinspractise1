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

	public String getExcelData(String sheetname, int rownum, int celnum) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Documents\\selenium excel\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(celnum);
		String value = cell.getStringCellValue();
		System.out.println(value);
		return value;

	}
	
	public String getExcelDataUsingDataFormatter(String sheetname,int rownum,int celnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Documents\\selenium excel\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(celnum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		System.out.println(value);
		return value;
		
	}

}
