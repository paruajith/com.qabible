package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public String path;
	public static FileInputStream f;// file read
	public static XSSFWorkbook w;// workbook read
	public static XSSFSheet s;// sheet read

	public ExcelRead(String path) {

		this.path = path;
		try {
			f = new FileInputStream(path);
			w = new XSSFWorkbook(f);
			f.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public Object[][] getTestData(String sheetName) {

		s = w.getSheet(sheetName);
		Object [][] data = new Object [s.getLastRowNum()][s.getRow(0).getLastCellNum()];
		for (int row=0;row<s.getLastRowNum();row++)
		{
			for(int col=0;col<s.getRow(0).getLastCellNum();col++)
			{
				data[row][col] = s.getRow(row+1).getCell(col).toString();
				//System.out.println(data[row][col]);
				
			}
		}
		
		return data;
	
		
	}

	public String getStringData(String sheet, int row, int column) throws IOException {

		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row-1);
		XSSFCell c = r.getCell(column);
		return c.getStringCellValue();
	}

	public String getIntegerData(String sheet, int row, int column) throws IOException {

		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row-1);
		XSSFCell c = r.getCell(column);
		int j = (int) c.getNumericCellValue();
		return String.valueOf(j);
	}

	public int getRowCount(String sheetName) {

		s = w.getSheet(sheetName);
		return s.getLastRowNum();

	}

	public int getColumnCount(String sheetName) {

		s = w.getSheet(sheetName);
		XSSFRow r = s.getRow(0);

		return r.getLastCellNum();

	}
}
