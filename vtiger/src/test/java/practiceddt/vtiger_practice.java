package practiceddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.reporters.jq.Main;

public class vtiger_practice {
	
	
	public static void main(String[] args) throws IOException {
		Random random= new Random();
		int ranInt = random.nextInt(1000);
		
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://localhost:8888/");
		
		FileInputStream fis = new FileInputStream("‪C:\\Users\\viren\\Desktop\\commondata.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		String data1 = prop.getProperty("browser");
		String data2 = prop.getProperty("url");
		String data3 = prop.getProperty("username");
		String data4 = prop.getProperty("password");
        

        System.out.println(data1+""+data2+""+data3);
		

		
		
		
		
		
		
		
		
		
	}

}
