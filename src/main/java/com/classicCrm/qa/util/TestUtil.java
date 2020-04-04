package com.classicCrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public static XSSFCell cell;
	public static DataFormatter formatter;
	
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
	
	public static void mouseHoverOnElement(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();;
	}
	
	public static Object[][] getTestData(String sName)
	{
		try
		{
			File f = new File("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\newContact.xlsx");
			FileInputStream file = new FileInputStream(f);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
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
	
	public static Object[][] getNewDealData(String sName)
	{
		try
		{
			File f = new File("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\testDeal.xlsx");
			FileInputStream file = new FileInputStream(f);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			
			
			for(int i =0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					formatter = new DataFormatter();
					data[i][k] = formatter.formatCellValue(sheet.getRow(i+1).getCell(k));
				}
			}
			
			//code to write the data and save it in excel file
			/*FileOutputStream fo = new FileOutputStream("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\testDeal.xlsx");
			workbook.write(fo);
			fo.close();*/
			
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

	public static Object[][] getNewDealDataUsingIfCondition(String sName)
	{
		try
		{
			File f = new File("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\testDeal.xlsx");
			FileInputStream file = new FileInputStream(f);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			
			for(int i =0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					
					cell = sheet.getRow(i+1).getCell(k);
					
					if(cell.getCellType() == Cell.CELL_TYPE_STRING)
					{
					    data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
					{
						data[i][k] = sheet.getRow(i+1).getCell(k).getNumericCellValue();
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
					{
						data[i][k] = "";
					}
					
				}
			}
			
			//code to write the data and save it in excel file
			/*FileOutputStream fo = new FileOutputStream("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\testDeal.xlsx");
			workbook.write(fo);
			fo.close();*/
			
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
	
	public static Object[][] getNewDealDataForStringAndNumerics(String sName)
	{
		try
		{
			File f = new File("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\testDeal.xlsx");
			FileInputStream file = new FileInputStream(f);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			
			for(int i =0;i<sheet.getLastRowNum();i++)
			{
				Row row = sheet.getRow(i);
				
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					Cell cell = row.getCell(k);
					switch(cell.getCellType())
					{
						case Cell.CELL_TYPE_STRING:
							data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();
							break;
							
						case Cell.CELL_TYPE_NUMERIC:
							data[i][k] = sheet.getRow(i+1).getCell(k).getNumericCellValue();
							break;
					}
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

