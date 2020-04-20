package com.classicCrm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.po.CreateNewCallPageClassicCrm;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;
import static com.classicCrm.qa.util.NewCallUtil.getNewCallData;;

public class CreateNewCallPageClassicCrmTest extends TestCrmBase 
{
	LoginPageClassicCrm loginPage;
	HomePageClassicCrm homePage;
	CreateNewCallPageClassicCrm createNewCall;
	String sheetName = "firstCallSheet";
	
	public CreateNewCallPageClassicCrmTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		browserInitialization();
		loginPage = new LoginPageClassicCrm();
		homePage = new HomePageClassicCrm();
		createNewCall = new CreateNewCallPageClassicCrm();
		homePage =loginPage.validateLoginFunctionality(configProp.getProperty("username"), configProp.getProperty("password"));
		createNewCall =homePage.clickOnNewCallLink();
		
	}
	
	@DataProvider
	public Object[][] getCreateNewCallDataProvider()
	{
		Object[][] data = getNewCallData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCreateNewCallDataProvider",enabled = true)
	public void createNewCallValidation(String Reminder__reminder_minutesDropDown_data,String Reminder__reminder_typeDropDown_data,String Reminder__reminder_note_date,
			String Reminder__contactentrytypeDropDown_data,String callTo_contactTextBox_data,String callTo_companyTextBox_data,
			String flagAsDropDown_data,String ended_DropDown_data,String endTimeMinute_textBox_data,String state_dropDown_data,
			String deal_textBox_data,String task_textBox_data,String case_textBox_data,String notes_textBox_data,String keyword_textBox_data,
			String flagDropDown_data,String assignedToDropDown_data,String dateDropDown_data,String statusDropDown_data)
	{
		createNewCall.createNewCall(Reminder__reminder_minutesDropDown_data, Reminder__reminder_typeDropDown_data, Reminder__reminder_note_date, Reminder__contactentrytypeDropDown_data, 
				callTo_contactTextBox_data, callTo_companyTextBox_data,flagAsDropDown_data, 
				ended_DropDown_data, endTimeMinute_textBox_data, state_dropDown_data, deal_textBox_data, task_textBox_data, case_textBox_data, 
				notes_textBox_data, keyword_textBox_data, flagDropDown_data, assignedToDropDown_data, dateDropDown_data, statusDropDown_data);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
