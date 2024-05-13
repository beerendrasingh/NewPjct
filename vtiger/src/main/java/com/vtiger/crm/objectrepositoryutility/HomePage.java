package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
     private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	
	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactButtonLink;
	
	public WebElement getCreateContactButtonLink() {
		return createContactButtonLink;
	}

	@FindBy(linkText= "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Sign Out" )
	private WebElement signOutLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	public void navigateToCampaignPage()
	{     Actions action = new Actions(driver);
	      action.moveToElement(moreLink).perform();
	      campaignlink.click();
	      
		
	}
	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		signOutLnk.click();
		
		
	}
	 
}
