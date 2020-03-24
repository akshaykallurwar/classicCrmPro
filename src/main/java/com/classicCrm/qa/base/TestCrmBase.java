package com.classicCrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.classicCrm.qa.listeners.WebEventListener;
import com.classicCrm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCrmBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static SoftAssert softAssert;
	public static String browserName;
	public static String userDirectory;
	
	
	
	public TestCrmBase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream fi = new FileInputStream("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\config\\config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void browserInitialization()
	{	
		browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		else
		{
			System.out.println("Invalid browserName is present in propertis file");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public void failedForScreenshot(String methodName)
	{
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("F:\\Sep2019\\classicCrmPro\\failedTestScreenshotsForBaseClass\\"+methodName+".jpg");
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (WebDriverException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
