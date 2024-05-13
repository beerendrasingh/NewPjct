package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestUsingDP {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstname , String lastname)
	{
		System.out.println("firstname"+ firstname + "lastname" + lastname );
 	}
	

	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="virendra";
		objArr[0][1]="hr";
		
		objArr[1][0]="sam";
		objArr[1][1]="sh";
		
		objArr[2][0]="jhon";
		objArr[2][1]="smith";
		
		
	return /*(Object[][])*/ objArr;
	}
}
