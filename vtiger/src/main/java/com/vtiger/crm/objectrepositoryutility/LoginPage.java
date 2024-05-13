package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
/**
 * @author virendra
 * Contains Login page elements and bussiness libraries like login() 
 */

public class LoginPage extends WebDriverUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Rule-1 create a separate java class
	// Rule-2 object creation

	@FindBy(name = "user_name")
	private WebElement usernamef;
	@FindBy(name = "user_password")
	private WebElement passwordf;
	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement loginf;
	// Rule-3 object initialization shud be done in test script only
	// rule 4-Object Encapsulation i.e provide getters and setters

	public WebElement getUsername() {
		return usernamef;
	}

	public WebElement getPassword() {
		return passwordf;
	}

	public WebElement getLogin() {
		return loginf;
	}

	// rule 5- write bussiness logic or provide action
    /**
     * login to application based on username,cpassword,url arguments
     * @param url
     * @param name
     * @param pass
     */
	public void loginToApp(String url, String name, String pass) {
		waitForPageToLoad(driver);

		driver.get(url);
		driver.manage().window().maximize();
		usernamef.sendKeys(name);
		passwordf.sendKeys(pass);

		loginf.click();

	}

}
