package practice.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class InvoiceTestListener extends BaseClass

{
	
	@Test
	public void creteInvoiceTest()
	{
		System.out.println("execute create invoice test ");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step:-1");
		System.out.println("step:-2");
		System.out.println("step:-3");
		System.out.println("step:-4");
	}
    @Test
    public void createInvoiceWithContactTest()
    {
    	System.out.println("execute invoice with contact test");
    	System.out.println("step:-1");
		System.out.println("step:-2");
		System.out.println("step:-3");
		System.out.println("step:-4");
    }
}
