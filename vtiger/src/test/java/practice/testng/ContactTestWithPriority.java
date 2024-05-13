package practice.testng;

import org.testng.annotations.Test;

public class ContactTestWithPriority {
	
	
	@Test(priority=1)
	public void createContactTest()
	{
		System.out.println("execute create contact");
	}
	@Test(priority=2)
	public void modifyContactTest()
	{
		System.out.println("modify contact test");
	}
	@Test(priority=3)
	public void deleteContactTest()
	{
		System.out.println("delete contact test");
	}

}

