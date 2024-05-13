package practice.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTestReporterLog {
	
	@Test
	public void test1()
	{
		System.out.println("execute test");
		Reporter.log("hello", true);
	}
	@Test
	    			public void test()
	{
		System.out.println("hello");
	}

}
