package com.zohoCRM.constants;

public final class FrameworkConstants {

	private static final String CHROMEDRIVER_PATH = System.getProperty("user.dir") + 
			"/src/test/resources/executables/chromedriver.exe";
	private static final String PROPERTY_FILE_PATH = System.getProperty("user.dir") + 
			"/src/test/resources/frameworkConfig/config.properties";


	private FrameworkConstants() {

	}




	public static String getPropertyFilePath() {
		return PROPERTY_FILE_PATH;
	}





	public static String getChromeDriverPath() {
		return CHROMEDRIVER_PATH;
	}



}
