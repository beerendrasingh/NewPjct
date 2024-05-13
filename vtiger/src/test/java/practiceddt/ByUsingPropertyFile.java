package practiceddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ByUsingPropertyFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("‪C:\\Users\\viren\\Desktop\\sheet1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		  org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Sheet1");
		  Row row = sh.getRow(1);
		  
		  String data = row.getCell(2).toString();
		  
		  System.out.println(data);
		 
		  
	    
	  
		
        		
		
		
		
		
		
		
		
		
	}

}
