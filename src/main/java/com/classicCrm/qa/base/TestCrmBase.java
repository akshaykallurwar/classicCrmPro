package com.classicCrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	public static Properties configProp;
	public static Properties log4jProp;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static SoftAssert softAssert;
	public static String browserName;
	public static String userDirectory;
	public static Logger logger;
	//What is log ? :- capturing the info/activities at the time of program execution
	//What are the types of logs :-
	//1. info 2. warning 3. debug 4.fatal
	
	//How to generate the logs :- use Apache log4j api
	//How it works :- it reads the log4j configuration from log4j.properties file
	//Where to create log4j.properties file ? -- inside resources source folder
	
	
	public TestCrmBase()
	{
		try 
		{
			configProp = new Properties();
			FileInputStream configFi = new FileInputStream("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\config\\config.properties");
			configProp.load(configFi);
			
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
		logger = Logger.getLogger(TestCrmBase.class);
		PropertyConfigurator.configure("F:\\Sep2019\\classicCrmPro\\src\\main\\resources\\log4j.properties");
		browserName = configProp.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("launching chrome browser");
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
		driver.get(configProp.getProperty("url"));
		logger.info("entering application url");
		logger.warn("This is just a warning message");
		logger.fatal("This is just a fatal error message");
		logger.debug("This is a debug message");
		
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
