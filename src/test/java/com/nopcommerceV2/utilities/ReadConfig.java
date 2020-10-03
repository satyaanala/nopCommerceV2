package com.nopcommerceV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
		public ReadConfig()
		{
			File src = new File("./Configuration/config.properties");  //it will load all the values from properties file  

			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
		}
		public String getApplicationURL()                        //user defined methods
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		 public String getUseremail()
		 {
		 String username=pro.getProperty("useremail");
		 return username;
		 }

		 public String getPassword()
		 {
		 String password=pro.getProperty("password");
		 return password;
		 }
		 public String getChromePath()
		 {
		 String chromepath=pro.getProperty("chromepath");
		 return chromepath;
		 }

		 }


