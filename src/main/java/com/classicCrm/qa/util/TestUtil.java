package com.classicCrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.classicCrm.qa.base.TestCrmBase;

public class TestUtil extends TestCrmBase
{
	public static long IMPLICIT_WAIT =20;
	public static long PAGELOAD_TIMEOUT =30;
	public static long EXPLICIT_WAIT =30;
	
	
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
	
	

}
