package com.classicCrm.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.po.ContactsPageClassicCrm;
import com.classicCrm.qa.po.DealsPageClassicCrm;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;
import com.classicCrm.qa.po.TasksPageClassicCrm;

public class HomePageClassicCrmTest extends TestCrmBase 
{
	LoginPageClassicCrm loginPage;
	ContactsPageClassicCrm contactsPage;
	DealsPageClassicCrm dealsPage;
	TasksPageClassicCrm tasksPage;
	HomePageClassicCrm homePage;
	
	public HomePageClassicCrmTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		browserInitialization();
		loginPage = new LoginPageClassicCrm();
		homePage=loginPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPageClassicCrm();
	}
	
	@Test(priority=1,enabled=true)
	public void validateHomePageTitleTest()
	{
		assertEquals(homePage.validateHomePageTitle(), "CRMPRO");
	}
	
	@Test(priority=2,enabled=true)
	public void validateLoggedInUserLabelTest()
	{
		assertTrue(homePage.validateLoggedInUserLabel(), "Issue with LoggedIn user label");
	}
	
	@Test(priority=3,enabled=true)
	public void validateclickOnContactsLinkTest()
	{
		contactsPage = homePage.validateclickOnContactsLink();
	}
	
	@Test(priority=4,enabled=true)
	public void validateclickOnDealsLinkTest()
	{
		dealsPage = homePage.validateclickOnDealsLink();
	}
	
	@Test(priority=5,enabled=true)
	public void validateclickOnTasksLink()
	{
		tasksPage = homePage.validateclickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	

}
