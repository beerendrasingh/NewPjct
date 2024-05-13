package practice.testng;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

public class ByUsingDependsOnOrderTest {
	
	
	@Test(dependsOnMethods = "createAnOrderTest" )
	public void billingAnOrderTest()
	{
		System.out.println("execute billing an order test=====>123");
		
	}
	@Test(invocationCount = 5)
	public void createAnOrderTest()
	{
		System.out.println("Execute create order Test====123");
		
		String str = null;
		System.out.println(str.equals("123"));
	}
	@Test(enabled = false)
	public void EnableCheck()
	{
		System.out.println("====checked enabled=====");
	}

}
