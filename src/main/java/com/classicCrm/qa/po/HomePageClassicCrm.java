package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.util.TestUtil;

public class HomePageClassicCrm extends TestCrmBase
{
	//page objects
	@FindBy(linkText = "Contacts")WebElement contactLink;
	@FindBy(linkText = "Deals")WebElement dealsLink;
	@FindBy(linkText = "Tasks")WebElement tasksLink;
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")WebElement loggedInUserLabel;
	
	//initializing page objects
	public HomePageClassicCrm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLoggedInUserLabel()
	{
		TestUtil.switchToFrame();
		return loggedInUserLabel.isDisplayed();
	}
	
	public ContactsPageClassicCrm clickOnContactsLink()
	{
		TestUtil.switchToFrame();
		return new ContactsPageClassicCrm();
	}
	
	
	public DealsPageClassicCrm clickOnDealsLink()
	{
		TestUtil.switchToFrame();
		return new DealsPageClassicCrm();
	}
	
	public TasksPageClassicCrm clickOnTasksLink()
	{
		TestUtil.switchToFrame();
		return new TasksPageClassicCrm();
	}
	
	

}
