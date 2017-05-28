package selenium.questionsAndAnswers;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Series9 {
	
	/**
	What are the methods of excel reader
	 */
	public static void main(String[] args) throws IOException {

		FileInputStream fis;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		
		fis = new FileInputStream("/src/main/java/com/automation/fb/data/text.xls");
		workbook = new XSSFWorkbook(fis);
		
		
		int index = workbook.getSheetIndex("LoginTest");
		sheet = workbook.getSheetAt(index);
		
		row = sheet.getRow(0);
		
		row.getLastCellNum();
		
		row.getLastCellNum();
		
		cell = row.getCell(3);

		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			String.valueOf(cell.getBooleanCellValue());
		} 
	}

}
