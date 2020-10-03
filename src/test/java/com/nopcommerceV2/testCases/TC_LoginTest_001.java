package com.nopcommerceV2.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {

	
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened");  //logger
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("user is provided");    //logger message
		
		lp.setPassword(password);
		logger.info("password is provided");   //logger message
		
		lp.clickLogin();
		logger.info("login is clicked");    //logger message
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login is passed");  //logger message
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login is failed");     //logger message
		}
	}
	
	
	
	
	
	
	
}
