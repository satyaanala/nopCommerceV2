package com.nopcommerceV2.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageObjects.AddcustomerPage;
import com.nopcommerceV2.pageObjects.LoginPage;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class TC_AddcustomerTest_003 extends BaseClass {
	
	
	@Test
	public void AddNewCustomer() throws IOException   //first we have to use login page
	{
      driver.get(baseURL);
      logger.info("URL is opened"); 
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("User name is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		
		lp.clickLogin();
        logger.info("providing customer details....");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guest");
		
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setGender("Male");
		
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
	
		addcust.clickOnSave();
		
		logger.info("validation started....");
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
}

		
	
	
	
	
	
	
	

}
