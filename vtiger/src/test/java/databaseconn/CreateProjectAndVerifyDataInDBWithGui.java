package databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGui {
	public static void main(String[] args) throws SQLException, InterruptedException {
		
		String projectname= "vtiger_beerendra3";
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		// create project in GUI
		
		
		driver.get("http://106.51.90.215:8084");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectname);
        driver.findElement(By.name("createdBy")).sendKeys("deepak");
		
		Select select =new Select(driver.findElement(By.name("status")));
		
		select.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//verify the project in DB using JDBC
		
		boolean flag = false;
		
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mySQL://106.51.90.215:3333/projects", "root@%", "root");
		{
		System.out.println("====connected===");
		}
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery("select* from project");
		
		while(resultset.next()) {
			String actProjectName = resultset.getString(4);
			
			if(projectname.equals(actProjectName)) {
				flag= true;
				System.out.println(projectname +"is available");
				
			}
		}
		if(flag==false) {
			System.out.println(projectname +"is not available");
			Assert.fail();
		}
		conn.close();
		
		
		
	}

}
