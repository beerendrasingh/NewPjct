package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
    
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	
	public String getDataFromExcel(String sheetName , int rowNum , int celnum) throws EncryptedDocumentException, IOException
	
	{
		FileInputStream fis = new FileInputStream("./testdata/Book3.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celnum).getStringCellValue();
		return data;
		
		
	}
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException{
	
		FileInputStream fis= new FileInputStream("./testdata/Book3.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		int rowCount= wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
		
	public void setDataIntoExcel(String sheetName ,int rowNum , int celNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./testdata/Book3.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
	
	FileOutputStream fos =  new FileOutputStream("./testdata/Book3.xlsx");
	wb.write(fos);
	wb.close();
	
	}
	
	
	
	

	
}
