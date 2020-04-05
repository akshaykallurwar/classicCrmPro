package com.classicCrm.qa.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.listeners.CustomClassicCrmListener;
import com.classicCrm.qa.po.ContactsPageClassicCrm;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;;

@Listeners(CustomClassicCrmListener.class)
public class ContactsPageClassicCrmTest extends TestCrmBase
{
	LoginPageClassicCrm loginPage;
	ContactsPageClassicCrm contactsPage;
	HomePageClassicCrm homePage;
	
	public ContactsPageClassicCrmTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		browserInitialization();
		loginPage = new LoginPageClassicCrm();
		homePage = new HomePageClassicCrm();
		contactsPage = new ContactsPageClassicCrm();
		homePage = loginPage.validateLoginFunctionality(configProp.getProperty("username"), configProp.getProperty("password"));
		homePage.clickOnContactsLink();	
	}
	
	@Test(priority = 1,enabled =true)
	public void validateContactsTableHeadingTest()
	{
		assertTrue(contactsPage.validateContactsTableHeading(), "Issue with contacts table Heading");
	}
	
	@Test(priority = 2,enabled =true)
	public void selectContactByNameTest()
	{
		try 
		{
			assertTrue(contactsPage.selectContactByName("apple pie"), "check box for contact not getting selected");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3,enabled =true)
	public void selectMultipleContactsByNameTest()
	{
		try 
		{
			assertTrue(contactsPage.selectMultipleContactsByName("apple pie", "ara pie"), "issue with check box while selecting multiple contacts");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
