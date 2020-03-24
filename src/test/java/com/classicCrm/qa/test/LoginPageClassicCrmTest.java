package com.classicCrm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.po.LoginPageClassicCrm;

public class LoginPageClassicCrmTest extends TestCrmBase
{
	LoginPageClassicCrm loginPage;
	
	public LoginPageClassicCrmTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		browserInitialization();
		loginPage = new LoginPageClassicCrm();
		softAssert = new SoftAssert();
	}

	@Test(priority=1,enabled=true)
	public void validateLoginPageLinksTest() 
	{
	  try 
	  {
		softAssert.assertTrue(loginPage.validateLoginPageLinks(), "Issue with validateLoginPageLinksTest");
		softAssert.assertAll();
	  } 
	  catch (Exception e) 
	  {
		System.out.println("Issue with validateLoginPageLinksTest");
		e.printStackTrace();
	  }
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
