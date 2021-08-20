package com.zohoCRM.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.zohoCRM.initDriver.Driver;


public class BaseTest {

	protected BaseTest() {
		
	}

	@BeforeMethod
	protected void setup() throws Exception {		
		Driver.initializeDriver();		
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();	
	}

}
