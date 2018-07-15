package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	
	
	public String[][] readExcel(String excelName) throws IOException{
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+excelName+".xlsx");
		XSSFSheet sheet = wBook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println("No of rows: "+rowCount);
		XSSFRow headerRow = sheet.getRow(0);
		int columnCount = headerRow.getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		System.out.println("No of columns: "+columnCount);
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
				data[i-1][j]=value;
			}
		}
		return data;
	}

}
