package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;
import static com.classicCrm.qa.util.TestUtil.selectByValueFromDropDown;;

public class CreateNewContactPageClassicCrm extends TestCrmBase
{
	//page objects
	
	//title dropDown
	@FindBy(name = "title")WebElement titleDropDown;//Mr.
	
	@FindBy(id = "first_name")WebElement firstName;
	@FindBy(id = "middle_initial")WebElement middleName;
	@FindBy(id = "surname")WebElement lastName;
	
	//suffix dropdown
	@FindBy(name = "suffix")WebElement suffixDropDown;//Esq.
	
	@FindBy(name = "nickname")WebElement nickName;
	@FindBy(name = "client_lookup")WebElement companyName;
	@FindBy(id = "company_position")WebElement position;
	@FindBy(id = "department")WebElement departmentName;
	@FindBy(name = "contact_lookup_sup")WebElement supervisor;
	@FindBy(name = "contact_lookup_ass")WebElement assistant;
	@FindBy(name = "contact_lookup_ref")WebElement referredBy;
	//Category drop down
	@FindBy(name = "category")WebElement categoryDropDown;//Friend
	
	//Status drop down
	@FindBy(name = "status")WebElement statusDropDown;//Active
	
	@FindBy(id = "phone")WebElement phone;
	@FindBy(id = "mobile")WebElement mobile;
	@FindBy(id = "home_phone")WebElement homePhone;
	@FindBy(id = "fax")WebElement fax;
	@FindBy(id = "email")WebElement email;
	@FindBy(id = "email_alt")WebElement emailAlternate;
	@FindBy(id = "im_id")WebElement messengerId;
	//messenger network drop down
	@FindBy(name = "im_netowrk")WebElement messengerNetworkDropDown;//AOL Messenger
	
	
	@FindBy(id = "skype_id")WebElement skypeId;
	//source drop down
	@FindBy(name = "source")WebElement sourceDropDown;//Customer
	
	
	@FindBy(name = "identifier")WebElement identifier;
	@FindBy(name = "address_title")WebElement addressTitle;
	//Type drop down
	@FindBy(name = "type")WebElement typeDropDown;//B
	
	
	@FindBy(name = "address")WebElement address;
	@FindBy(name = "city")WebElement city;
	@FindBy(name = "state")WebElement state;
	@FindBy(name = "postcode")WebElement postcode;
	@FindBy(name = "country")WebElement country;
	@FindBy(id = "tags")WebElement tags;
	@FindBy(id = "description")WebElement description;
	//contact time zone drop down
	@FindBy(name = "time_zone")WebElement contactTimeZoneDropDown;//ACT
	
	
	//filter time zone by country drop down
	@FindBy(name = "country")WebElement filterTimeZoneByCountryDropDown;//AL
	@FindBy(xpath = "//form[@name='contactForm']//input[@value='Save']")WebElement saveButton;
	
	
	
	public CreateNewContactPageClassicCrm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String title,String firstNameS,String middleNameS,String lastNameS,String suffixS,String nickNameS,String companyNameS,
			String positionS,String departmentNameS,String supervisorS,String assistantS,String referredByS,String categoryS,String statusS,String phoneS,String mobileS,
			String homePhoneS,String faxS,String emailS,String emailAlternateS,String messengerIdS,String messengerNetworkS,String skypeIdS,String sourceS,String identifierS,String addressTitleS,
			String typeS,String addressS,String cityS,String stateS,String postcodeS,String countryS,String tagsS,String descriptionS,String contactTimeZoneS)
	{
		try
		{
			selectByValueFromDropDown(titleDropDown, title);
			firstName.sendKeys(firstNameS);
			middleName.sendKeys(middleNameS);
			lastName.sendKeys(lastNameS);
			selectByValueFromDropDown(suffixDropDown, suffixS);
			nickName.sendKeys(nickNameS);
			companyName.sendKeys(companyNameS);
			position.sendKeys(positionS);
			departmentName.sendKeys(departmentNameS);
			supervisor.sendKeys(supervisorS);
			assistant.sendKeys(assistantS);
			referredBy.sendKeys(referredByS);
			selectByValueFromDropDown(categoryDropDown, categoryS);
			selectByValueFromDropDown(statusDropDown, statusS);
			phone.sendKeys(phoneS);
			mobile.sendKeys(mobileS);
			homePhone.sendKeys(homePhoneS);
			fax.sendKeys(faxS);
			email.sendKeys(emailS);
			emailAlternate.sendKeys(emailAlternateS);
			messengerId.sendKeys(messengerIdS);
			selectByValueFromDropDown(messengerNetworkDropDown, messengerNetworkS);
			skypeId.sendKeys(skypeIdS);
			selectByValueFromDropDown(sourceDropDown, sourceS);
			identifier.sendKeys(identifierS);
			addressTitle.sendKeys(addressTitleS);
			selectByValueFromDropDown(typeDropDown, typeS);
			address.sendKeys(addressS);
			city.sendKeys(cityS);
			state.sendKeys(stateS);
			postcode.sendKeys(postcodeS);
			country.sendKeys(countryS);
			tags.sendKeys(tagsS);
			description.sendKeys(descriptionS);
			selectByValueFromDropDown(contactTimeZoneDropDown, contactTimeZoneS);
			//selectByValueFromDropDown(filterTimeZoneByCountryDropDown, filterTimeZoneByCountryS);
			saveButton.click();
			
		}
		catch(Exception e)
		{
			System.out.println("Inside catch block of createNewContact");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
