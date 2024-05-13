package practiceddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteDataBack {
	public static void main(String[] args) {
		
		
		FileInputStream fis = new FileInputStream(‪"C:\\Users\\viren\\Desktop\\sheet1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		 Sheet sh = wb.getSheet("Sheet1");
		 Row row = sh.getRow(1);
		 
		 Cell cell = row.createCell(5);
		 cell.setCellValue("false");
		 
		 FileOutputStream fos= new FileOutputStream(‪"C:\\Users\\viren\\Desktop\\sheet1.xlsx");
		 
		 wb.write(fos);
		 wb.close();
		 
		 System.out.println("======EXECUTED=======");
		 
		 
		 
		 
	}

}
 