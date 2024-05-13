package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name= "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDB;
	
	@FindBy(id = "phone")
	private WebElement phoneEdt;
	
	
	public WebElement getIndustryDB() {
		return industryDB;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createorg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String phone)
	{
	orgNameEdt.sendKeys(orgName);
	phoneEdt.sendKeys(phone);
	saveBtn.click();
	}
	public void createorg(String orgName, String industry)
	{
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	
		
	
}
	


