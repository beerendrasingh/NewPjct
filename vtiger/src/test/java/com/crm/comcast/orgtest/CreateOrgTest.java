package com.crm.comcast.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.listenerutility.ListenerImplementationClass;
import com.vtiger.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.vtiger.crm.listenerutility.ListenerImplementationClass.class)
public class CreateOrgTest extends BaseClass{
	
	@Test
	
	public void createOrgTest() throws EncryptedDocumentException, IOException
	{
		// read test script data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		
		String orgName = eu.getDataFromExcel("org", 1, 3); //+ ju.getRandomNmber();
		//navigate to organization module
		ListenerImplementationClass.test.log(Status.INFO, "navigate to organization module");
		
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		
		
		// click on create organization button 
		UtilityClassObject.getTest().log(Status.INFO, "click on create organization button");
		
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateOrgBtn().click();
		
		//enter all the details and create new organization page 
		UtilityClassObject.getTest().log(Status.INFO, "enter all the details");
		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgName);
		UtilityClassObject.getTest() .log(Status.INFO, orgName + "read data from excel");
		
		//verify header mssg expected result 
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		
		String actOrgName = oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println(orgName + "name is verified ====pass");
			
		}else
		{
			System.out.println(orgName + "name is not verified ==== fail");
		}
		
	}
	   @Test
	   public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException
	   {
		   String orgName = eu.getDataFromExcel("org", 1, 2) + ju.getRandomNmber();
		   String phoneNumber = eu.getDataFromExcel("org", 7, 3)+ju.getRandomNmber();
		   
		   // step2:- navigate to organization module 
		   HomePage hp = new HomePage(driver);
		   hp.getOrgLink().click();
		   
		   //click on create organization button 
		   
		   OrganizationsPage cnp = new OrganizationsPage(driver);
		   cnp.getCreateOrgBtn().click();
		   
		   // enter all details and create new organization button 
		   
		   CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		   cnop.createOrg(orgName, phoneNumber);
		   
		   //verify the phone info 
		   
		   String actNum = driver.findElement(By.id("dtlview_Phone")).getText();
		   System.out.println(actNum);
		   if(actNum.trim().equals(phoneNumber))
		   {
			   System.out.println(phoneNumber + "information is verified === pass");
			   
		   }else
		   {
			   System.out.println(phoneNumber + "information is not verified ====fail");
		   }
	   }
	   
	   
	   @Test
	   public void createOrganizationWithIndustries() throws EncryptedDocumentException, IOException
	   {
		   // read the data from excel sheet 
		   String orgName = eu.getDataFromExcel("org", 4, 2)+ju.getRandomNmber();
				   String industry = eu.getDataFromExcel("org", 4, 3);
				   String type = eu.getDataFromExcel("org", 4, 4);
						   
		   // navigate to organization module 
						   HomePage hp = new HomePage(driver);
				   hp.getOrgLink().click();
		   // click on create organization button 
				   OrganizationsPage cnp = new OrganizationsPage(driver);
				   cnp.getCreateOrgBtn().click();
				   
				   //enter all details and create new organization button 
				   
				   CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
				   cnop.createorg(orgName, industry);
				   
				   // verify the dropdown industries and type info 
				   
				   
				   String actualIndustries = driver.findElement(By.id("mouseArea_Industry")).getText();
				   if(actualIndustries.equals(industry))
				   {
					   System.out.println(industry + "information is verified ==== pass");
				   }else
				   {
					   System.out.println(industry + "information is not verified ====fail");
				   }
				   
				   String actualType = driver.findElement(By.id("dtlview_Type")).getText();
						   System.out.println(actualType);
				   if(actualType.equals(type))
				   {
					  System.out.println(type + "information is verified====pass"); 
				   }else 
				   {
					   System.out.println(type + "information is not verified ====fail");
				   }
						   
				   
					   
						   
	   }
	
	
	
	


}
