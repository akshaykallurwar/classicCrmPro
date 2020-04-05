package com.classicCrm.qa.test;

import static com.classicCrm.qa.util.TestUtil.getNewDealData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.listeners.CustomClassicCrmListener;
import com.classicCrm.qa.po.CreateNewDealsPageClassicCrm;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;;

@Listeners(CustomClassicCrmListener.class)
public class CreateNewDealsPageClassicCrmTest extends TestCrmBase 
{
	LoginPageClassicCrm loginPageD;
	HomePageClassicCrm homePageD;
	//TestUtil testUtil;
	CreateNewDealsPageClassicCrm createNewDealObj;
	String sheetName = "firstDealSheet";
	
	
	public CreateNewDealsPageClassicCrmTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		browserInitialization();
		//testUtil = new TestUtil();
		loginPageD = new LoginPageClassicCrm();
		homePageD = new HomePageClassicCrm();
		createNewDealObj = new CreateNewDealsPageClassicCrm();
		loginPageD.validateLoginFunctionality(configProp.getProperty("username"), configProp.getProperty("password"));
		createNewDealObj = homePageD.clickOnNewDealsLink();
		
	}
	
	@DataProvider
	public Object[][] getCreateNewDealTestData()
	{
		Object data[][] = getNewDealData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider = "getCreateNewDealTestData")
	public void validateCreateNewDealTest(String titlet,String companyt,String primaryContactt,String amountt,String probabilityt
			,String commissiont,String identifiert,String productt,String quantityt,String typet,String sourcet,
			String tagst,String descriptiont,String nextStept)
	{
		createNewDealObj.createNewDeal(titlet, companyt, primaryContactt, amountt, probabilityt, commissiont, identifiert,
				productt, quantityt, typet, sourcet, tagst, descriptiont, nextStept);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
