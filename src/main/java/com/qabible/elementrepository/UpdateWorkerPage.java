package com.qabible.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class UpdateWorkerPage {

	WebDriver driver;
	GeneralUtilities objGeneralUtilities = new GeneralUtilities();

	public UpdateWorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement updatePageHeader;
	@FindBy(xpath = "//input[@id='worker-first_name']")
	WebElement firstNameField;
	@FindBy(xpath = "//input[@id='worker-known']")
	WebElement workerKnownNameField;

	public String getHeaderForThePage() {

		return objGeneralUtilities.getHeaderTextForElement(updatePageHeader);

	}

	public String getValueFromTheFirstNameFieldOrKnownNameField() {
		
		if(objGeneralUtilities.getAttributeValueForAnElement(workerKnownNameField, "value").isEmpty()) {
			return objGeneralUtilities.getAttributeValueForAnElement(firstNameField, "value");
		}
		else
		{
			return objGeneralUtilities.getAttributeValueForAnElement(workerKnownNameField, "value");
		}
				
	}
	public String getfirstNameFromTheField() {
		return objGeneralUtilities.getAttributeValueForAnElement(firstNameField, "value");
	}

	public String getKnownNameFromTheField() {
		return objGeneralUtilities.getAttributeValueForAnElement(workerKnownNameField, "value");
	}

}
