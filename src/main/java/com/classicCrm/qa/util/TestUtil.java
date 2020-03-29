package com.classicCrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classicCrm.qa.base.TestCrmBase;

public class TestUtil extends TestCrmBase
{
	public static long IMPLICIT_WAIT =20;
	public static long PAGELOAD_TIMEOUT =30;
	public static long EXPLICIT_WAIT =30;
	public static WebDriverWait webDriverWait;
	public static Object[][] data;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public static void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static void takeErrorScreenshotAtEndOfTest()
	{
		try 
		{
			userDirectory = System.getProperty("user.dir");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(userDirectory+"errorScreenshots_"+System.currentTimeMillis()+".jpg");
			FileUtils.copyFile(srcFile, destFile);
		} catch (WebDriverException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static void clickElementsByJavaScript(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static boolean isElementPresent(WebElement element)
	{
		boolean isPre = false;
		if(element.isDisplayed())
		{
			isPre = true;
			return isPre;
		}
		return isPre;
	}
	
	public static boolean isElementClickable(WebElement element)
	{
		boolean isClick = false;
		if(isElementPresent(element))
		{
			if(element.isEnabled())
			{
				isClick = true;
				return isClick;
			}
		}
		return isClick;
	}
	
	public static void explicitWaitForNoSuchElementException(WebElement element)
	{
		webDriverWait = new WebDriverWait(driver, EXPLICIT_WAIT);
		webDriverWait.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void selectByValueFromDropDown(WebElement dropDown,String value)
	{
		Select select = new Select(dropDown);
		select.selectByValue(value);
	}
	
	public static void selectByVisibleTextFromDropDown(WebElement dropDown,String visibleText)
	{
		Select select = new Select(dropDown);
		select.selectByVisibleText(visibleText);
	}
	
	public static void selectByIndexFromDropDown(WebElement dropDown,int val)
	{
		Select select = new Select(dropDown);
		select.selectByIndex(val);
	}
	
	public static Object[][] getTestData(String sName)
	{
		try
		{
			File f = new File("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\newContact.xlsx");
			FileInputStream file = new FileInputStream(f);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			//System.out.println(sheet.getLastRowNum());
			//System.out.println(sheet.getRow(0).getLastCellNum());
			
			for(int i =0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue(); 
				}
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		return data;
	}
	
	

}
