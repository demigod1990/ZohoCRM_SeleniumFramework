package com.zohoCRM.initDriver;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.zohoCRM.constants.FrameworkConstants;
import com.zohoCRM.utility.ReadPropertyFile;

public class Driver {

	private static WebDriver driver;
	


	public static void initializeDriver() throws Exception {
		System.out.println("Initializing the Driver");

		if(Objects.isNull(DriverManager.getThreadSafeDriver())) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DriverManager.setThreadSafeDriver(driver);
			DriverManager.getThreadSafeDriver().get(ReadPropertyFile.get("url"));			

		}

	}

	public static void quitDriver() {
		System.out.println("Quitting Driver");

		if(Objects.nonNull(DriverManager.getThreadSafeDriver())) {
			DriverManager.getThreadSafeDriver().quit();
			DriverManager.unloadThreadSafeDriver();			
		}

	}


}
