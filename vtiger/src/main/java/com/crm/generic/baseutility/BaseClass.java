package com.crm.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.crm.generic.databaseutility.DataBaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public DataBaseUtility db = new DataBaseUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver =null;
	
     
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("====Login====");
		String URL = fu.getDataFromPropertiesFile("url");
		String USERNAME = fu.getDataFromPropertiesFile("username");
		String PASSWORD = fu.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("======Logout====");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
     
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})	
	public void configBC(/*String browser*/) throws IOException {
		System.out.println("====LaunchTheBrowser===");
		String BROWSER =// browser;
						fu.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();

		}sdriver = driver;
		// create the utility for static variables 
		UtilityClassObject.setDriver(driver);
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("====Close The Browser=====");
		driver.quit();
	}

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("====Connect to DB , Report config");
		db.getDbconnection();
		
			

	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===close DB ,Report BackUP=====");
		db.closeDbconnection();
		
	}

}
