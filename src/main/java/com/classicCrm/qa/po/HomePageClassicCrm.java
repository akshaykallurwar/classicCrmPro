package com.classicCrm.qa.po;

import static com.classicCrm.qa.util.TestUtil.explicitWaitForNoSuchElementException;
import static com.classicCrm.qa.util.TestUtil.mouseHoverOnElement;
import static com.classicCrm.qa.util.TestUtil.switchToFrame;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;;

public class HomePageClassicCrm extends TestCrmBase
{
	//write test case to create "new call" and delete the call and then validate that the call was deleted successfully
	
	//page objects
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")WebElement contactLink;
	@FindBy(xpath = "//a[contains(text(),'Deals')]")WebElement dealsLink;
	@FindBy(xpath = "//a[contains(text(),'New Deal')]")WebElement newDealsLink;
	@FindBy(how = How.XPATH,using = "//a[@title='Call' and contains(text(),'Call')]")WebElement callLink;
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'New Call')]")WebElement newCallLink;
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
	
	//method to click on New Deals link
	public CreateNewDealsPageClassicCrm clickOnNewDealsLink()
	{
		switchToFrame();
		explicitWaitForNoSuchElementException(dealsLink);
		mouseHoverOnElement(dealsLink, driver);
		explicitWaitForNoSuchElementException(newDealsLink);
		newDealsLink.click();
		return new CreateNewDealsPageClassicCrm();
		
	}
	
	//method to click on New call link
	public CreateNewCallPageClassicCrm clickOnNewCallLink()
	{
		switchToFrame();
		explicitWaitForNoSuchElementException(callLink);
		mouseHoverOnElement(callLink, driver);
		explicitWaitForNoSuchElementException(newCallLink);
		newCallLink.click();
		return new CreateNewCallPageClassicCrm();
	}
	
	

}
