package com.classicCrm.qa.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.listeners.CustomClassicCrmListener;
import com.classicCrm.qa.po.CreateNewDealsPageClassicCrm;
import com.classicCrm.qa.po.CreatedDealVerificationPageClassicCrm;
import com.classicCrm.qa.po.HomePageClassicCrm;
import com.classicCrm.qa.po.LoginPageClassicCrm;
import com.classicCrm.qa.util.TestUtil;

@Listeners(CustomClassicCrmListener.class)
public class CreatedDealVerificationPageClassicCrmTest extends TestCrmBase 
{
	LoginPageClassicCrm loginPageObj;
	HomePageClassicCrm homePageObj;
	CreateNewDealsPageClassicCrm createNewDealObj;
	CreatedDealVerificationPageClassicCrm createdDealObj;
	String sheetName = "firstDealSheet";
	
	@DataProvider
	public Object[][] getdealTestData()
	{
		Object data[][] = TestUtil.getNewDealData(sheetName);
		return data;
	}
	
	public CreatedDealVerificationPageClassicCrmTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		browserInitialization();
		loginPageObj = new LoginPageClassicCrm();
		homePageObj = new HomePageClassicCrm();
		createNewDealObj = new CreateNewDealsPageClassicCrm();
		createdDealObj = new CreatedDealVerificationPageClassicCrm();
		homePageObj = loginPageObj.validateLoginFunctionality(configProp.getProperty("username"), configProp.getProperty("password"));
		createNewDealObj = homePageObj.clickOnNewDealsLink();
		
	}
	
	@Test(dataProvider = "getdealTestData",priority = 1)
	public void createdDealNumberMatchTest(String titlet,String companyt,String primaryContactt,String amountt,String probabilityt
			,String commissiont,String identifiert,String productt,String quantityt,String typet,String sourcet,
			String tagst,String descriptiont,String nextStept)
	{
		createdDealObj =createNewDealObj.createNewDeal(titlet, companyt, primaryContactt, amountt, probabilityt, commissiont, identifiert,
				productt, quantityt, typet, sourcet, tagst, descriptiont, nextStept);
		String dealVal_From_Created_Deal = createdDealObj.createdDealNumberVerification();//Deal: 10095 : rewr
		String dealVal_From_Create_Deal = CreateNewDealsPageClassicCrm.dealNumber.toString();//10095
		System.out.println(dealVal_From_Created_Deal);
		System.out.println(dealVal_From_Create_Deal);
		assertTrue(dealVal_From_Created_Deal.contains(dealVal_From_Create_Deal));
		
	}
	
	@Test(dataProvider = "getdealTestData",priority = 2)
	public void validateHeaderLinksPresentTest(String titlet,String companyt,String primaryContactt,String amountt,String probabilityt
			,String commissiont,String identifiert,String productt,String quantityt,String typet,String sourcet,
			String tagst,String descriptiont,String nextStept)
	{
		createdDealObj =createNewDealObj.createNewDeal(titlet, companyt, primaryContactt, amountt, probabilityt, commissiont, identifiert,
				productt, quantityt, typet, sourcet, tagst, descriptiont, nextStept);
		boolean flag =createdDealObj.validateHeaderLinksPresent();
		assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
