package com.classicCrm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.listeners.CustomClassicCrmListener;
import com.classicCrm.qa.po.ContactsPageClassicCrm;
import com.classicCrm.qa.po.CreateNewContactPageClassicCrm;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;;

@Listeners(CustomClassicCrmListener.class)
public class CreateNewContactPageClassicCrmTest extends TestCrmBase
{
	LoginPageClassicCrm loginPage;
	HomePageClassicCrm homePage;
	ContactsPageClassicCrm contactsPage;
	CreateNewContactPageClassicCrm createNewContactPage;
	
	public CreateNewContactPageClassicCrmTest() 
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
		createNewContactPage = new CreateNewContactPageClassicCrm();
		loginPage.validateLoginFunctionality(configProp.getProperty("username"), configProp.getProperty("password"));
		homePage.clickOnContactsLink();
		createNewContactPage = contactsPage.clickOnNewContactButton();
		
	}
	
	@Test
	public void createNewContactTest()
	{
		createNewContactPage.createNewContact("Mr.", "Akshay", "Vithal", "Kallu", "Esq.", "Kallu", "CTS", "PA", "Testing",
				"None", "Abc", "Hem", "Friend", "Active", "9421927356", "8857838457", "56974582", "114562", "aks@gmail.com", "abbusi@gmail.com", 
				"kalluTikTok", "AOL Messenger", "63581", "Customer", "shaggy", "home", "B", "rest", "Pune", "Maharashtra", "411057", 
				"India", "Nothing", "Trying to be better everyday", "ACT");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
