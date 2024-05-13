package practice.coding.standards;
/**
 * test class for Contact module
 * @author virendra
 */

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
	/**
	 *   scenario : login()=> navigate contact==>createcontact()===verify
	 */
	@Test
	public void searchContactTest()
	{   /*step 1: login to app*/
		
	   LoginPage lp = new LoginPage(driver);
 	   lp.loginToApp("url", "username", "password");
	}

}
