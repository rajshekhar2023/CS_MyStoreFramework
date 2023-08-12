package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="C:\\Users\\Kalshetti\\eclipse-workspace\\MyStoreV1\\Configuration\\config.properties";
	
	public ReadConfig()
	{
		try {
		  
			properties= new Properties();
		    FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public String getbaseurl()
		{
			String value=properties.getProperty("baseurl");
			
			if(value!=null)
			    return value;
			else
				throw new RuntimeException("url not specified in config file");
		}
		public String getbrowser()
		{
			String value=properties.getProperty("browser");
			
			if(value!=null)
			    return value;
			else
				throw new RuntimeException("browser not specified in config file");
		}
		public String getemail()
		{
			String value=properties.getProperty("email");
			
			if(value!=null)
			    return value;
			else
				throw new RuntimeException("Emailid not specified in config file");
		}
		public String getpassword()
		{
			String value=properties.getProperty("password");
			
			if(value!=null)
			    return value;
			else
				throw new RuntimeException("password not specified in config file");
		}
		
		
	}


