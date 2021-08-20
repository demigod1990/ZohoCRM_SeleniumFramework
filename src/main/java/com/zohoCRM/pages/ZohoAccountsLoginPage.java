package com.zohoCRM.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohoCRM.initDriver.DriverManager;

public class ZohoAccountsLoginPage {


	WebDriver driver;

	/*	
	 * Element locators
	 * Page Elements Related to Registration Page
	 * Author: Subhankar Bagchi
	 * 
	 */

	@FindBy (xpath="//input[@id='login_id']")
	WebElement input_EmailID;

	@FindBy (xpath="//input[@id='password']")
	WebElement input_Password;

	@FindBy (xpath="//span[contains(text(),'Next')]/parent::button[@id='nextbtn']")
	WebElement btn_Next;

	@FindBy (xpath="//span[contains(text(),'Sign in')]//parent::button[@id='nextbtn']")
	WebElement btn_SignIn;
	
	@FindBy (xpath="//div[@id='password_container']/div[@class='hellouser']/div[@class='username']")
	WebElement field_Username;
	
	@FindBy (xpath="//div[@class='fielderror errorlabel']")
	WebElement label_ErrorMessage;


	/*	
	 * Class Constructors
	 * To initialize the class members
	 * Author: Subhankar Bagchi
	 * 
	 */

	public ZohoAccountsLoginPage() {		
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
	
	public void verify_PageTitle(String expectedTitle) {
		Assertions.assertThat(driver.getTitle())
			.withFailMessage(() -> "Page title did not match")
			.isEqualToIgnoringCase(expectedTitle);
		
		System.out.println("page Title verified successfully");
	}
	
	
	public void enterEmail(String username) {
		input_EmailID.sendKeys(username);
		System.out.println("Email is entered");
	}
	
	public void click_btn_Next() {
		btn_Next.click();
		System.out.println("Next button clicked");
	}
	
	public void verify_Username(String username) {
		String displayedUsername = field_Username.getText();
		Assertions.assertThat(displayedUsername).withFailMessage(() -> "The Username did not match").isEqualTo(username);
		System.out.println("user name verified");
	}
	
	
	public void enterPassword(String password) {
		input_Password.sendKeys(password);
		System.out.println("password entered");
	}
	
	public void click_btn_SignIn() {
		btn_SignIn.click();
		System.out.println("signin button clicked");
	}
	
	public void verify_Login(String username, String password) {
		
		enterEmail(username);
		click_btn_Next();
		verify_Username(username);
		enterPassword(password);
		click_btn_SignIn();
		
	}
	
	public void verify_ErrorMessage() {
		Assertions.assertThat(label_ErrorMessage.getText())
			.withFailMessage(() -> "The error message is not proper").containsIgnoringCase("Please try again");
	}


}
