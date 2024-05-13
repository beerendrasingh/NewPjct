package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ByUsingRetryAnalyzer {
	
	  @Test(retryAnalyzer = com.vtiger.crm.listenerutility.RetryListenerImplementationClass.class)
	    public void activateSim()
	    {
	    	System.out.println("execute create invoice test");
	    	Assert.assertEquals("", "Login");
	    	System.out.println("step:-1");
			System.out.println("step:-2");
			System.out.println("step:-3");
			System.out.println("step:-4");
	    }
	}
	


