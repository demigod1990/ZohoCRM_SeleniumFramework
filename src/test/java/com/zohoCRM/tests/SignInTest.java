package com.zohoCRM.tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.zohoCRM.initDriver.DriverManager;
import com.zohoCRM.pages.RegistrationPage;
import com.zohoCRM.pages.ZohoAccountsLoginPage;

public class SignInTest extends BaseTest{

	@Test
	public void verify_SignIn() throws InterruptedException {
		
		
		/* Click Sign In button from Registration Page */
		RegistrationPage rp = new RegistrationPage();
		rp.click_SIGN_IN();
		
		/* Perform Sign In by entering Username and Password in Zoho Accounts Login page */
		ZohoAccountsLoginPage zlp = new ZohoAccountsLoginPage();
		zlp.verify_PageTitle("Zoho Accounts");
		zlp.enterEmail("subha.crmqa@gmail.com");
		zlp.click_btn_Next();
		zlp.enterPassword("Test123");
		zlp.click_btn_SignIn();
		zlp.verify_ErrorMessage();

	}

}
