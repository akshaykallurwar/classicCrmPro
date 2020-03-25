package com.classicCrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;

public class LoginPageClassicCrmTest extends TestCrmBase
{
	LoginPageClassicCrm loginPage;
	HomePageClassicCrm homePage;
	
	public LoginPageClassicCrmTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		browserInitialization();
		loginPage = new LoginPageClassicCrm();
		homePage = new HomePageClassicCrm();
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
	
	@Test(priority =2,enabled=true)
	public void validateLoginPageTitleTest()
	{
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority =3,enabled=true)
	public void validateLoginFunctionalityTest()
	{
		homePage =loginPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
