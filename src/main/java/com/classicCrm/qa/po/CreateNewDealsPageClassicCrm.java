package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;
import static com.classicCrm.qa.util.TestUtil.selectByValueFromDropDown;
import static com.classicCrm.qa.util.TestUtil.selectByVisibleTextFromDropDown;
public class CreateNewDealsPageClassicCrm extends TestCrmBase 
{
	//page objects
	@FindBy(xpath = "//input[@type='text' and @name='sequence']")WebElement dealNumbertextBox;//deal number for validation purpose
	@FindBy(id = "title")WebElement titleTextBox;
	@FindBy(xpath = "//input[@name='client_lookup']")WebElement companyTextBox;
	@FindBy(xpath = "//input[@name='contact_lookup']")WebElement primaryContactTextBox;
	@FindBy(xpath = "//input[@name='amount']")WebElement amountTextBox;
	@FindBy(id = "probability")WebElement probabilityTextBox;
	@FindBy(id = "commission")WebElement commissionTextBox;
	@FindBy(xpath = "//input[@name='identifier']")WebElement identifierTextBox;
	@FindBy(xpath = "//select[@name='product_id']")WebElement productDropDown;//value to select is 373193 (pants)
	@FindBy(id = "quantity")WebElement quantityTextBox; // first clear the textBox
	@FindBy(xpath = "//select[@name='type' and @size='1']")WebElement typeDropDown; //value to select is Opportunity
	@FindBy(xpath = "//select[@name='source']")WebElement sourceDropDown;//value to select is Existing Customer
	@FindBy(xpath = "//input[@type='radio' and @value='Y']")WebElement status_closedRadioButton;
	@FindBy(id = "tags")WebElement tagsTextBox;
	@FindBy(id = "description")WebElement descriptionTextBox;
	@FindBy(id = "next_step")WebElement nextStepTextBox;
	@FindBy(xpath = "//form[@name='prospectForm']//input[@value='Save']")WebElement saveButton;
	public static String dealNumber;
	
	//initialize pageFactory objects
	public CreateNewDealsPageClassicCrm() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public CreatedDealVerificationPageClassicCrm createNewDeal(String title,String company,String primaryContact,String amount,String probability
			,String commission,String identifier,String product,String quantity,String type,String source,
			String tags,String description,String nextStep)
	{
		try 
		{
			dealNumber = dealNumbertextBox.getAttribute("value");
			titleTextBox.sendKeys(title);
			companyTextBox.sendKeys(company);
			primaryContactTextBox.sendKeys(primaryContact);
			amountTextBox.sendKeys(amount);
			probabilityTextBox.sendKeys(probability);
			commissionTextBox.sendKeys(commission);
			identifierTextBox.sendKeys(identifier);
			selectByVisibleTextFromDropDown(productDropDown, product);
			quantityTextBox.clear();
			quantityTextBox.sendKeys(quantity);
			selectByValueFromDropDown(typeDropDown, type);
			selectByValueFromDropDown(sourceDropDown, source);
			status_closedRadioButton.click();
			tagsTextBox.sendKeys(tags);
			descriptionTextBox.sendKeys(description);
			nextStepTextBox.sendKeys(nextStep);
			saveButton.click();
			
			return new CreatedDealVerificationPageClassicCrm();
		} 
		catch (Exception e) 
		{
			System.out.println("Some error occured in createNewDeal Method");
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
