package com.zohoCRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohoCRM.initDriver.DriverManager;

public final class RegistrationPage {

	WebDriver driver;

	/*	
	 * Element locators
	 * Page Elements Related to Registration Page
	 * Author: Subhankar Bagchi
	 * 
	 */


	@FindBy(xpath = "//div[@class='zgh-utilities']//a[contains(text(),'SIGN IN')]")
	private WebElement btn_SIGN_IN;
	@FindBy(xpath = "//*[@id='signupModalButton']")
	private WebElement getStarted;

	
	/*	
	 * Class Constructors
	 * To initialize the class members
	 * Author: Subhankar Bagchi
	 * 
	 */
	
	
	public RegistrationPage() {		
		driver = DriverManager.getThreadSafeDriver();
		PageFactory.initElements(driver, this);
	}
	
	/*	
	 * Page Methods
	 * To interact with the class members
	 * These methods to be used for TestCases
	 * Author: Subhankar Bagchi
	 * 
	 */
	
	
	public void click_SIGN_IN() {
		btn_SIGN_IN.click();
	}
	



}
