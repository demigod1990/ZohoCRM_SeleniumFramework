package com.zohoCRM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.zohoCRM.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private static Properties prop = new Properties();
	private static final Map <String,String> CONFIG_MAP = new HashMap<>();

	static {
		try {
			File propertyFile = new File (FrameworkConstants.getPropertyFilePath());
			FileInputStream fis = new FileInputStream (propertyFile);
			prop.load(fis);
			
			prop.entrySet().forEach(entry -> CONFIG_MAP
					.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	private ReadPropertyFile() {

	}

	public static String get(String key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
			throw new Exception ("Prperty name {" + key + "} does not exist. Please check Properties file.");			 
		}		
		return CONFIG_MAP.get(key);		
	}

}
