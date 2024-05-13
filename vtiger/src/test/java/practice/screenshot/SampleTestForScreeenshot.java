package practice.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreeenshot {
	@Test
	public void amazonTest() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//step 1:- create an object to eventfiring webdriver
		// EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//step2:-use get screenshotAs method to get file type of screenshot
		
		File source = edriver.getScreenshotAs(OutputType.FILE);
		
		// step 3:- store  screenshot in local drive
		File target = new File("./screenshot/test1.png");
		
		FileUtils.copyFile(source,target);
		
		driver.close();
		
	}

}
