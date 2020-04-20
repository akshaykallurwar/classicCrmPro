package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.classicCrm.qa.base.TestCrmBase;
import static com.classicCrm.qa.util.TestUtil.explicitWaitForElementNotInteractableException;
import static com.classicCrm.qa.util.TestUtil.selectByValueFromDropDown;;

public class CreateNewCallPageClassicCrm extends TestCrmBase 
{
	//page locators
	@FindBy(how = How.NAME ,using = "reminder_minutes")WebElement Reminder__reminder_minutesDropDown;//value to select = 60
	@FindBy(how = How.CSS, using = "select[name='reminder_type']")WebElement Reminder__reminder_typeDropDown;//value to select = S
	@FindBy(how = How.CSS, using = "input[type='text'][name='reminder_note']")WebElement Reminder__reminder_note;
	@FindBy(how = How.CSS, using = "select[name='contactentrytype']")WebElement Reminder__contactentrytypeDropDown;//value to select = NOTEXISTS
	@FindBy(how = How.CSS, using = "input[name='contact_lookup']")WebElement callTo_contactTextBox;
	@FindBy(how = How.CSS, using = "input[name='client_lookup']")WebElement callTo_companyTextBox;
	@FindBy(how = How.CSS, using = "input[name='conf_call']")WebElement callTo_conf_conferenceCallCheckBox;
	@FindBy(how = How.CSS, using = "form[name='callForm'] select[name='flag']")WebElement flagAsDropDown;//value to select = Call Backs
	@FindBy(how = How.CSS, using = "select[name='end_time_hour']")WebElement ended_DropDown;//value to select = 5
	@FindBy(how = How.CSS, using = "input[name='end_time_minute']")WebElement endTimeMinute_textBox;
	@FindBy(how = How.CSS, using = "select[name='closed']")WebElement state_dropDown;//value to select = Y
	@FindBy(how = How.CSS, using = "input[name='prospect_lookup']")WebElement deal_textBox;
	@FindBy(how = How.CSS, using = "input[name='task_lookup']")WebElement task_textBox;
	@FindBy(how = How.CSS, using = "input[name='case_lookup']")WebElement case_textBox;
	@FindBy(how = How.CSS, using = "textarea[name='notes']")WebElement notes_textBox;
	@FindBy(how = How.CSS, using = "form[name = 'CFForm_1'] input[type='text'][name='search']")WebElement keyword_textBox;
	@FindBy(how = How.CSS, using = "form[name = 'CFForm_1'] select[name = 'flag']")WebElement flagDropDown;//value to select = Left Message
	@FindBy(how = How.CSS, using = "select[name='cs_assigned_to_user_id']")WebElement assignedToDropDown;//value to select = 433680
	@FindBy(how = How.CSS, using = "select[name='call_date_field']")WebElement dateDropDown;//value to select = start_time
	@FindBy(how = How.CSS, using = "select[name='call_status']")WebElement statusDropDown;//value to select = closed
	@FindBy(how = How.XPATH, using = "(//input[@type='submit' and @name='save'])[1]")WebElement saveButton;
	
	
	//initializing page objects
	public CreateNewCallPageClassicCrm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCall(String Reminder__reminder_minutesDropDown_data,String Reminder__reminder_typeDropDown_data,String Reminder__reminder_note_date,
			String Reminder__contactentrytypeDropDown_data,String callTo_contactTextBox_data,String callTo_companyTextBox_data,
			String flagAsDropDown_data,String ended_DropDown_data,String endTimeMinute_textBox_data,String state_dropDown_data,
			String deal_textBox_data,String task_textBox_data,String case_textBox_data,String notes_textBox_data,String keyword_textBox_data,
			String flagDropDown_data,String assignedToDropDown_data,String dateDropDown_data,String statusDropDown_data)
	{
		try 
		{
			selectByValueFromDropDown(Reminder__reminder_minutesDropDown, Reminder__reminder_minutesDropDown_data);
			selectByValueFromDropDown(Reminder__reminder_typeDropDown, Reminder__reminder_typeDropDown_data);
			Reminder__reminder_note.sendKeys(Reminder__reminder_note_date);
			selectByValueFromDropDown(Reminder__contactentrytypeDropDown, Reminder__contactentrytypeDropDown_data);
			explicitWaitForElementNotInteractableException(callTo_contactTextBox).sendKeys(callTo_contactTextBox_data);
			explicitWaitForElementNotInteractableException(callTo_companyTextBox).sendKeys(callTo_companyTextBox_data);
			callTo_conf_conferenceCallCheckBox.click();
			selectByValueFromDropDown(flagAsDropDown, flagAsDropDown_data);
			selectByValueFromDropDown(ended_DropDown, ended_DropDown_data);
			endTimeMinute_textBox.sendKeys(endTimeMinute_textBox_data);
			selectByValueFromDropDown(state_dropDown, state_dropDown_data);
			deal_textBox.sendKeys(deal_textBox_data);
			task_textBox.sendKeys(task_textBox_data);
			case_textBox.sendKeys(case_textBox_data);
			notes_textBox.sendKeys(notes_textBox_data);
			keyword_textBox.sendKeys(keyword_textBox_data);
			selectByValueFromDropDown(flagDropDown, flagDropDown_data);
			selectByValueFromDropDown(assignedToDropDown, assignedToDropDown_data);
			selectByValueFromDropDown(dateDropDown, dateDropDown_data);
			selectByValueFromDropDown(statusDropDown, statusDropDown_data);
			saveButton.click();
			
		} catch (Exception e) 
		{
			logger.info("Some issue with the createNewCall method");
			e.printStackTrace();
		}
	}
	
}
