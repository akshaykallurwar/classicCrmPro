package com.classicCrm.qa.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classicCrm.qa.base.TestCrmBase;
import static com.classicCrm.qa.util.TestUtil.isElementClickable;

public class CreatedDealVerificationPageClassicCrm extends TestCrmBase 
{
	//page objects
	@FindBy(css = "td[id='all']")WebElement allTab;
	@FindBy(css = "td[id='tab_vsummary']")WebElement summaryTab;
	@FindBy(css = "td[id='tab_vcontacts']")WebElement contactsTab;
	@FindBy(css = "td[id='tab_vproduct']")WebElement productsTab;
	@FindBy(css = "td[id='tab_vevents']")WebElement calenderTab;
	@FindBy(css = "td[id='tab_vcalls']")WebElement callsTab;
	@FindBy(css = "td[id='tab_vtasks']")WebElement tasksTab;
	@FindBy(css = "td[id='tab_vdocs']")WebElement documentsTab;
	@FindBy(css = "td[id='tab_vnotes']")WebElement notesTab;
	@FindBy(css = "td[id='tab_vwebresources']")WebElement webTab;
	@FindBy(xpath = "//td[contains(text(),'Deal:')]")WebElement createdDealNumber;
	
	//initializing page objects
	public CreatedDealVerificationPageClassicCrm() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateHeaderLinksPresent()
	{
		try {
			if (isElementClickable(allTab)) {
				if (isElementClickable(summaryTab)) {
					if (isElementClickable(contactsTab)) {
						if (isElementClickable(productsTab)) {
							if (isElementClickable(calenderTab)) {
								if (isElementClickable(callsTab)) {
									if (isElementClickable(tasksTab)) {
										if (isElementClickable(documentsTab)) {
											if (isElementClickable(notesTab)) {
												if (isElementClickable(webTab)) {
													if (isElementClickable(createdDealNumber)) {
														return true;
													} else {
														System.out.println("Issue with createdDealNumber");
													}
												} else {
													System.out.println("Issue with webTab");
												}
											} else {
												System.out.println("Issue with notesTab");
											}
										} else {
											System.out.println("Issue with documentsTab");
										}
									} else {
										System.out.println("Issue with tasksTab");
									}
								} else {
									System.out.println("Issue with callsTab");
								}
							} else {
								System.out.println("Issue with calenderTab");
							}
						} else {
							System.out.println("Issue with productsTab");
						}
					} else {
						System.out.println("Issue with contactsTab");
					}

				} else {
					System.out.println("Issue with summaryTab");
				}

			} else {
				System.out.println("Issue with allTab");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String createdDealNumberVerification()
	{
		String dealNumber = createdDealNumber.getText();
		return dealNumber;
	}
	
	

	
	
}
