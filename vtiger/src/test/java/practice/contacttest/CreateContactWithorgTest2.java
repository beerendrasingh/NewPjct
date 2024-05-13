package practice.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithorgTest2 {
	       public static void main(String[] args) {
			
		
	
	// read common data from property file
			FileInputStream fis = new FileInputStream("C:\\Users\\viren\\Desktop\\data2\\commondata.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String BROWSER = prop.getProperty("browser");
			String URL = prop.getProperty("url");
			String USERNAME = prop.getProperty("username");
			String PASSWORD = prop.getProperty("password");
			
			// generate random number
			
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			
			//read testscript data from excel file
			
			FileInputStream fis1= new FileInputStream("C:\\Users\\viren\\Desktop\\data2\\Book3.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis1);
			
			 Sheet sh = wb.getSheet("Sheet1");
	           Row row= sh.getRow(1);
	           
	          String orgName = row.getCell(2).toString() + randomInt;
	          String contactLastname=row.getCell(5).toString();
	          
	         wb.close();
	         
	         WebDriver driver = null;
	         if(BROWSER.equals("chrome")) {
	        	 driver=new ChromeDriver();
	         }else if(BROWSER.equals("firefox")) {
	        	 driver=new FirefoxDriver();
	        	 
	         }else if(BROWSER.equals("edge")) {
	        	 driver= new EdgeDriver();
	         }else {
	        	
	        	 driver= new ChromeDriver();
	         }
	     
	         
	         //login to app
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 		  driver.get(URL);
	 		
	 		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 		driver.findElement(By.id("submitButton")).click();
	 		
	 		//step2: navigate to organization module
	 		
	 		driver.findElement(By.linkText("Organizations")).click();
	 		//step3: click on "create organization" button
	 		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 		
	 		//step4: enter all the details and create  new organization
	 		
	 		driver.findElement(By.name("accountname")).sendKeys(orgName);
	 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 		
	 		//======verify header phone number info Expected result
	 		String headerInfo =driver.findElement(By.xpath(contactLastname));
	 		if(headerInfo.contains(orgName)) {
	 			System.out.println(orgName + "header is verified===pass");
	 		}else
	 		{
	 			System.out.println(orgName + "header is not verified===fail");
	 			
	 		}
	 		
	 		// step 5: navigate to organization module
	 		
	 		driver.findElement(By.linkText("contacts")).click();
	 		
	 		// step 6: click on create organization button
	 		
	 		
	 		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 		
	 		// step 7: enter all the details and create new organizaton
	 		
	 		driver.findElement(By.name("lastname")).sendKeys(contactLastname);00000
	 		driver.findElement(By.xpath("//input[@name=]"))
	 		
	 		
	 		
	 			
	 		
	 		
	 		
	 		
	 				
	 				
	 		
	 		
	 		
	       }
}
