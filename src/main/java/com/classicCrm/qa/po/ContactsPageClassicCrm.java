package com.classicCrm.qa.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;
import static com.classicCrm.qa.util.TestUtil.switchToFrame;;

public class ContactsPageClassicCrm extends TestCrmBase
{
	
	//page objects
	@FindBy(xpath ="//td[contains(text(),'Contacts')]")WebElement contactsTableHeading;
	@FindBy(xpath = "//input[@type='button' and @value='New Contact']")WebElement newContactButton;
	
	
	//intializing page objects
	public ContactsPageClassicCrm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsTableHeading()
	{
		return contactsTableHeading.isDisplayed();
	}
	
	public boolean selectContactByName(String cName)
	{
		boolean isContactSelected = false;
		WebElement checkBoxOne = driver.findElement(By.xpath("//a[text()='"+cName+"']/parent::td//preceding-sibling::td//input"));
		checkBoxOne.click();
		if(checkBoxOne.isSelected())
		{
			isContactSelected = true;
			return isContactSelected;
		}
		return isContactSelected;
	}
	
	public boolean selectMultipleContactsByName(String cName1,String cName2)
	{
		boolean areContactsSelected = false;
		WebElement contactOne = driver.findElement(By.xpath("//a[text()='"+cName1+"']/parent::td//preceding-sibling::td//input"));
		WebElement contactTwo = driver.findElement(By.xpath("//a[text()='"+cName2+"']/parent::td//preceding-sibling::td//input"));
		contactOne.click();
		contactTwo.click();
		if(contactOne.isSelected()&&contactTwo.isSelected())
		{
			areContactsSelected = true;
			return areContactsSelected;
		}
		return areContactsSelected;
	}
	
	public CreateNewContactPageClassicCrm clickOnNewContactButton()
	{
		//switchToFrame();
		newContactButton.click();
		return new CreateNewContactPageClassicCrm();
	}
	

}
