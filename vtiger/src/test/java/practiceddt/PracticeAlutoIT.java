package practiceddt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeAlutoIT {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/auth?sublist=0");
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Runtime.getRuntime().exec("C:\\Program Files (x86)\\AutoIt3\\SciTE\\..\\Aut2Exe\\Aut2exe.exe");
		
		
	}

}
