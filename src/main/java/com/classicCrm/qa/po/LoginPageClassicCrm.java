package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;
import com.classicCrm.qa.util.TestUtil;;
public class LoginPageClassicCrm extends TestCrmBase
{
	public boolean isValidLogin;
	
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
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginPageLinks()
	{
		isValidLogin = false;

		if (TestUtil.isElementClickable(homeLink)) {
			if (TestUtil.isElementClickable(signUpLink)) {
				if (TestUtil.isElementClickable(pricingLink)) {
					if (TestUtil.isElementClickable(featuresLink)) {
						if (TestUtil.isElementClickable(customersLink)) {
							if (TestUtil.isElementClickable(contactLink)) {
								isValidLogin = true;
								System.out.println("Inside mehtod validateLoginPageLinks-----------------------------------------------------");
								return isValidLogin;
							}
						} else {
							System.out.println("Issue with customersLink");
						}
					} else {
						System.out.println("Issue with featuresLink");
					}
				} else {
					System.out.println("Issue with pricingLink");
				}
			} else {
				System.out.println("Issue with signUpLink");
			}
		} else {
			System.out.println("Issue with homeLink");
		}
		return isValidLogin;
	}
	
	public String validateLoginPageTitle()
	{
		String loginPageTitle = driver.getTitle();
		return loginPageTitle;
	}
	
	public HomePageClassicCrm validateLoginFunctionality(String un,String pass)
	{
		usernameTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pass);
		TestUtil.clickElementsByJavaScript(loginButton);
		return new HomePageClassicCrm();
		
	}
	
	
	
	

}
