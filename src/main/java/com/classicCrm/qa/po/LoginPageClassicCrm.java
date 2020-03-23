package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;

public class LoginPageClassicCrm extends TestCrmBase
{
	//creating page objects for Login Page
	
	@FindBy(linkText = "Home")
	WebElement homeLink;
	@FindBy(linkText = "Sign Up")
	WebElement signUpLink;
	@FindBy(linkText = "Pricing")
	WebElement pricingLink;
	@FindBy(linkText ="Features")
	WebElement featuresLink;
	@FindBy(linkText = "Customers")
	WebElement customersLink;
	@FindBy(linkText = "Contact")
	WebElement contactLink;
	@FindBy(name="username")
	WebElement usernameTextBox;
	@FindBy(name = "password")
	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginButton;
	
	//Initializing page factory using initElements() method
	public LoginPageClassicCrm() 
	{
		PageFactory.initElements(driver, LoginPageClassicCrm.class);
	}

}
