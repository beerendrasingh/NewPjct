package com.vtiger.crm.orgtest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws IOException {
		
		//create object
		
		WebDriverUtility wLib = new WebDriverUtility();
	
	
	
	// read common data from properties file
	
			FileInputStream fis = new FileInputStream("C:\\Users\\viren\\Desktop\\data2\\commondata.properties");
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
			 
			 FileInputStream fis1 = new FileInputStream("C:\\Users\\viren\\Desktop\\data2\\Book3.xlsx");
			 
			Workbook wb= WorkbookFactory.create(fis1);
					Sheet sh= wb.getSheet("Sheet1");
			
			Row row = sh.getRow(10);
			String orgName =row.getCell(2).toString()+ randomInt;
			
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
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			//verify header mssg expected result
			
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName))
			{
				System.out.println(orgName+ "is created");
			}else
				System.out.println(orgName+ "is not created");
			
			
			// verify header org name into expected result
			
			String actOrgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actOrgname.equals(orgName))
			{
				System.out.println(orgName+ "is created===pass");
			}else
				System.out.println(orgName+ "is not created=====fail"); 
			
			//go back to organization page
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();
			// search for organization
			
			OrganizationsPage op = new OrganizationsPage(driver);
			op.getSearchEdt().sendKeys(orgName);
			wLib.select(op.getSearchDD(), "Organization No");
			op.getSearchbtn().click();
			
			//in dynamic webtable select and delete org
			driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
			driver.switchTo().alert().accept();
			System.out.println("===pass org is deleted======");
	
			
			
			// to logout from application 
			Actions act= new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
			
			
	}	
	
			
			
		}


