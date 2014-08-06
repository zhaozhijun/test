package com.erayt.dao.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	public static final String DRIVER="driver";
	public static final String URL="url";
	public static final String USERNAME="username";
	public static final String PASSWORD="password";
	
	private static Properties pro=null;
	
	static {
		pro=new Properties();
		try {
			pro.load(ConfigManager.class.getClassLoader().getResourceAsStream("db\\dbConnection.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return pro.getProperty(key);
	}
}
