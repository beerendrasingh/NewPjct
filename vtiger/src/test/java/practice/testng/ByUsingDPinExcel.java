package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.crm.generic.fileutility.ExcelUtility;

public class ByUsingDPinExcel {
	
	
	@Test(dataProvider = "getdata")
	public void getProductInfoTest(String brandName, String productName)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		// search product
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		// capture product info 
		
		
		String x="//span[text()='"+productName+"']/../../../../div[3]/div/div[1]/div/div/div/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
		
		
	}
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	
	
	{
		
		ExcelUtility eLib =new ExcelUtility();
		int rowcount = eLib.getRowcount("Sheet1(2)");
		
		Object[][] objArr = new Object[rowcount][2];
		
  		{
		objArr[i][0] = eLib.getDataFromExcel("Sheet1(2)", i+1, 0);
		
		objArr[i][1] = eLib.getDataFromExcel("Sheet1(2)", i+1, 1);
		}
	
		return objArr;
	}

}


