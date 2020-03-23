package com.classicCrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.classicCrm.qa.base.TestCrmBase;

public class TestUtil extends TestCrmBase
{
	
	
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
	
	

}
