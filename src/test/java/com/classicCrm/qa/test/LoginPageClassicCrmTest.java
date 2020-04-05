package com.classicCrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.listeners.CustomClassicCrmListener;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;

@Listeners(CustomClassicCrmListener.class)
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
		logger.info("******************************** starting test case ********************************");
		logger.info("******************************** validateLoginPageLinksTest ********************************");
		softAssert.assertTrue(loginPage.validateLoginPageLinks(), "Issue with validateLoginPageLinksTest");
		softAssert.assertAll();
		logger.info("******************************** ending test case ********************************");
		logger.info("******************************** validateLoginPageLinksTest ********************************");
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
		logger.info("******************************** starting test case ********************************");
		logger.info("******************************** validateLoginPageTitleTest ********************************");
		logger.info("LoginPageClassicCrm page tilte is "+loginPage.validateLoginPageTitle());
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "CRMPRO - CRM software for customer relationship management, sales, and support.");
		logger.info("******************************** ending test case ********************************");
		logger.info("******************************** validateLoginPageTitleTest ********************************");
	}
	
	@Test(priority =3,enabled=true)
	public void validateLoginFunctionalityTest()
	{
		logger.info("******************************** starting test case ********************************");
		logger.info("******************************** validateLoginFunctionalityTest ********************************");
		homePage =loginPage.validateLoginFunctionality(configProp.getProperty("username"), configProp.getProperty("password"));
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
		logger.info("******************************** ending test case ********************************");
		logger.info("******************************** validateLoginFunctionalityTest ********************************");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
