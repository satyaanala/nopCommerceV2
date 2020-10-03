package com.nopcommerceV2.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageObjects.LoginPage;
import com.nopcommerceV2.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends  BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest (String user, String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened");  //logger                 //write data provider method first
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("user is provided");    //logger message
		
		lp.setPassword(pwd);
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
			//captureScreen(driver,"loginTest");  //not required because it is ddt
			Assert.assertTrue(false);
			logger.info("login is failed");     //logger message
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
			{
		      String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerceV2/testData/LoginData.xlsx";
		      int rownum=XLUtils .getRowCount(path,"Sheet1");
		      int colcount= XLUtils.getCellCount(path,"Sheet1",1);
		     
		      String logindata[][]=new String[rownum][colcount];   // creating 2 dimentional array [5,2]
				
				for(int i=1;i<=rownum;i++)//repeating the no.of rows from excel
				{
					for(int j=0;j<colcount;j++)//repeating the columns from excel   //1,0from excel
					{
						logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);  //put 1,0 value in 0,0 array(it will read the data from excel store that in array)
					}
				}
				return logindata; 
			}

}
//it will read the data from excel and store that in 2 dimentional array
