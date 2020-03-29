package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.classicCrm.qa.base.TestCrmBase;
import static com.classicCrm.qa.util.TestUtil.switchToFrame;
import static com.classicCrm.qa.util.TestUtil.explicitWaitForNoSuchElementException;;

public class HomePageClassicCrm extends TestCrmBase
{
	//page objects
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")WebElement contactLink;
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
		switchToFrame();
		return loggedInUserLabel.isDisplayed();
	}
	
	public ContactsPageClassicCrm validateclickOnContactsLink()
	{
		switchToFrame();
		return new ContactsPageClassicCrm();
	}
	
	
	public DealsPageClassicCrm validateclickOnDealsLink()
	{
		switchToFrame();
		return new DealsPageClassicCrm();
	}
	
	public TasksPageClassicCrm validateclickOnTasksLink()
	{
		switchToFrame();
		return new TasksPageClassicCrm();
	}
	
	//method to click on Contacts Link
	public void clickOnContactsLink()
	{
		switchToFrame();
		explicitWaitForNoSuchElementException(contactLink);
		contactLink.click();
	}
	
	

}
