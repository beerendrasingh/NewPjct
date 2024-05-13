package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithPhone {
	
public static void main(String[] args) throws IOException {
		
		// read common data from properties file
		
		FileInputStream fis = new FileInputStream("C:\\Users\\viren\\Desktop\\test\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//generate the random number 
		
		Random random = new Random();
		 int randomInt = random.nextInt(1000);
		 
		 // read   data from excel
		 
		 FileInputStream fis1 = new FileInputStream("‪C:\\Users\\viren\\Desktop\\data2\\Book3.xlsx");
		 
		Workbook wb= WorkbookFactory.create(fis1);
				Sheet sh= wb.getSheet("Sheet1");
		
		Row row = sh.getRow(7);
		String orgName =row.getCell(2).toString()+ randomInt;
		String phonenumber = row.getCell(3).getStringCellValue() ;

		
		
		wb.close();
		
		WebDriver driver = null;
		
		
		if (BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else 
		{
			driver= new ChromeDriver();
			
		}
		
		// step1: login to app
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step2: navigate to organization module
		
		driver.findElement(By.linkText("Organizations")).click();
		//step3: click on "create organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step4: enter all the details and create organization
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.id("phone")).sendKeys(phonenumber);
		driver.findElement(By.xpath("//input[@title='save [Alt+S]']")).click();
		
		
		
		
		// verify the dropdown industry and type
		
		String actphone= driver.findElement(By.id("mouseArea_Phone")).getText();
		if(actphone.equals(phonenumber))
		{
			System.out.println(phonenumber+ "is created");
		}else
			System.out.println(phonenumber+ "is not created");
		
		
		
		
		
		
		
		// to logout from application 
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
		
		
		
		
	}

		
	}

}
