package practiceddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToFetchMultipleData {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	FileInputStream fis = new FileInputStream("‪C:\\Users\\viren\\Desktop\\multipledata.xlsx");
	
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int rowcount =sh.getLastRowNum();
	

	for(int i =1;i<=rowcount;i++)
		
		Row row = sh.getRow(i);
		
	
	String column1Data = row.getCell(1).toString();
	String column2Data = row.getCell(2).toString();
	
	System.out.println(column1Data);
	System.out.println(column2Data);
	
	wb.close();
	
	
	
		
	
	}
	
	
	
	


}
 