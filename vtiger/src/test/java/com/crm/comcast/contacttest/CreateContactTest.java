package com.crm.comcast.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.ContactPage;
import com.vtiger.crm.objectrepositoryutility.CreatingNewContactpage;
import com.vtiger.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass
{
	
	@Test
	
	public void createContact() throws EncryptedDocumentException, IOException
	{
		
		//read testscript data from excel file
		 String lastName = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNmber();
		 
		 // step 2: navigate to contact module
		 
		
		 
		 HomePage hp = new HomePage(driver);
		 hp.getContactlink().click();
		 // step3 : click on "create contact " button
		 
		 HomePage cp = new HomePage(driver);
		 cp.getCreateContactButtonLink().click();
		 
		 // step4:- enter all the details and create new contact
		 
		 CreatingNewContactpage ccp = new CreatingNewContactpage(driver);
		 ccp.createContactWithlastName(lastName);
		 ccp.getSaveBtnLink().click();
		 
		 // verify Header contact info expected result 
		 ContactPage cpage = new ContactPage(driver);
				// cpage.getHeaderMsg()
		 
		 String actHeader = cpage.getHeaderMsg().getText();
		 boolean status =  actHeader.contains(lastName);
		 Assert.assertEquals(status, true);
		 
		 String actlastNam = driver.findElement(By.id("dtlview_Last Name")).getText();
		 SoftAssert soft = new SoftAssert();
		 soft.assertEquals(actlastNam, lastName);
		 soft.assertAll();
		/* System.out.println(actlastNam + "this is act last name");
		 if(actlastNam.contains(lastName))
		 {
			 System.out.println(lastName +"is created ===pass" );
		 }else
		 {
			 System.out.println(lastName + "is not created====fail");
			 
		 }*/

	}
	
      @Test
      public void createContactWithSupportDate() throws EncryptedDocumentException, IOException
      {
    	  String lastName = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNmber();
    	  
    	  
    	  //step 2:- navigate to contact module 
    	  HomePage hp = new HomePage(driver);
 		 hp.getContactlink().click();
 		 
 // step3 : click on "create contact " button
		 
		 HomePage cp = new HomePage(driver);
		 cp.getCreateContactButtonLink().click();
		 
		 // enter all the details and create new contact
		 
		 String startDate = ju.getSystemDateYYYYDDMM();
		 String endDate = ju.getRequiredDateYYYYDDMM(30);
		 
		 
		 CreatingNewContactpage ccp = new CreatingNewContactpage(driver);
		 ccp.createContactWithSupportdate(lastName, startDate, endDate);
		 ccp.getSaveBtnLink().click();
		 
		 String staDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		 if(staDate.equals(startDate))
		 {
			 System.out.println(startDate + "is created === pass");
		 }else
		 {
			 System.out.println(startDate + "is not created =====fail");
		 }
		 
		 String enDate =driver.findElement(By.id("dtlview_Support End Date")).getText();
		 System.out.println(enDate);
		 if(enDate.trim().equals(endDate))
		 {
			 System.out.println(endDate + "is created ====pass");
		 }else
		 {
			 System.out.println(endDate + "is not created====fail");
		 }
    	  
      }
      
        @Test
        public void createContactWithOrganization() throws EncryptedDocumentException, IOException
        {
        	
        	String orgName = eu.getDataFromExcel("contact", 7, 2)+ ju.getRandomNmber();
        	String lastName = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNmber();
        	
        	
        	//step2:- navigate to organization module 
        	
        	HomePage hp = new HomePage(driver);
        	hp.getOrgLink().click();
        	
        	// step3 :- click on create organization button 
        	
        	OrganizationsPage cnp = new OrganizationsPage(driver);
        	cnp.getCreateOrgBtn().click();
        	
        	// step 4:- enter all the details and create new organization
        	
        	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
        	cnop.createorg(orgName);
        	
        	//verify header mssg expected result 
        	
        	String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        	if(headerInfo.contains(orgName))
        	{
        		System.out.println(orgName + "header verified ====pass");
        	}else
        	{
        		System.out.println(orgName + "header is not verified === fail");
        	}
        	
        	// navigate to contact module
        	
        	hp.getContactlink().click();
        	
        	//enter all details and create new contact
        	
        	CreatingNewContactpage ccp = new CreatingNewContactpage(driver);
        	ccp.getCreateButtonLink().click();
        	ccp.createContactWithlastName(lastName);
        	ccp.getSaveBtnLink().click();
        	
        	String headerInfo1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        	if(headerInfo1.contains(lastName))
        	{
        		System.out.println(lastName + "header verified ====pass");
        	}else
        	{
        		System.out.println(lastName + "header is not verified === fail");
        	}        
      
           // verify header orgname info expected result 
        	
        	String actualArgnameInfo = driver.findElement(By.id("mouseArea_Organization Name")).getText();
        	System.out.println(actualArgnameInfo);
        	if(actualArgnameInfo.trim().equals(orgName))
        	{
        		System.out.println(orgName+ "is created====pass");
        	}else
        	{
        		System.out.println(orgName + "is not created=====fail");
        	}
	
	
	
        }
}
