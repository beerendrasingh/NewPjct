package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoDP {
	
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
	public Object[][] getdata()
	
	
	{
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "iphone";
		objArr[0][1] = "Apple iPhone 15 (128 GB) - Black";
		
		objArr[1][0] = "iphone";
		objArr[1][1] = "Apple iPhone 13 (128GB) - Pink";
		//same bhi kr skte
		objArr[2][0] = "iphone";
		objArr[2][1] = "Apple iPhone 15 Plus (128 GB) - Black";
		return objArr;
	}

}
