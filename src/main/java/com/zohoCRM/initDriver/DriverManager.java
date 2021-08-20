package com.zohoCRM.initDriver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();


	private DriverManager(){

	}

	public static WebDriver getThreadSafeDriver() {
		return threadSafeDriver.get();
	}

	protected static void setThreadSafeDriver(WebDriver driver) {
		threadSafeDriver.set(driver);
	}

	public static void unloadThreadSafeDriver() {
		threadSafeDriver.remove();
	}


}
