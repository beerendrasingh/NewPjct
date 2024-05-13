package practice.testng;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class practiceReporterLog {
	
	@Test
	public void homePageTest(Method mtd)
	{
		Reporter.log(mtd.getName() + "test start");
		Reporter.log("step1", true);// use true to show the report in html console also
		Reporter.log("step2", true);
		Reporter.log("step3", true);
		Reporter.log(mtd.getName()+ "test end");
	}

}
