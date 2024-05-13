package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgtest {

	public static void main(String[] args) throws IOException {

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

		// read testscript data from excel file

		FileInputStream fis1 = new FileInputStream("C:\\Users\\viren\\Desktop\\data2\\Book3.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);

		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);

		String orgName = row.getCell(2).toString() + randomInt;
		String contactLastname = row.getCell(5).toString() + randomInt;

		wb.close();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {

			driver = new ChromeDriver();
		}

		// login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step2: navigate to organization module

		driver.findElement(By.linkText("Contacts")).click();
		// step3: click on "create organization" button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step4: enter all the details and create organization

		driver.findElement(By.name("lastname")).sendKeys(contactLastname);
		Date dateObj = new Date();

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(dateObj);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sim.format(cal.getTime());

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify the dropdown industry and type

		String actstartDate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		System.out.println(actstartDate);
		if (actstartDate.trim().equals(startDate)) {
			System.out.println(startDate + "is created");
		} else
			System.out.println(startDate + "is not created");

		String actenddate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		System.out.println(actenddate);
		if (actenddate.trim().equals(endDate)) {
			System.out.println(endDate + "is created ");

		} else {
			System.out.println(endDate + "is not created");
		}

	}

}
