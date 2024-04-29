package com.qabible.elementrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class BankDetailsPage {
	GeneralUtilities objGeneralUtilities = new GeneralUtilities();
	WebDriver driver;
    WaitUtility objectWaitUtility = new WaitUtility();
    
	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement pageHeaderWorkerBankDetails;

	public String returnFullPageHeader() {
		objectWaitUtility.waitUntilDesiredTextAppears(driver,pageHeaderWorkerBankDetails,"WORKER BANK DETAILS: SALBIN NULL THOMAS");
		return objGeneralUtilities.getTextForAnElement(pageHeaderWorkerBankDetails);
	}

}
