package com.qabible.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	
	GeneralUtilities objGeneralUtilities = new GeneralUtilities();

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement loggedinUser;
	
	@FindBy(xpath="//a[text()='Workers']")
	WebElement workersTab;
	
	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientsTab;
	
	@FindBy(xpath = "//a[text()='Deduction']")
	WebElement deductionTab;
	
	@FindBy(xpath = "//a[text()='TimeSheet']")
	WebElement timeSheetTab;
	
	@FindBy(xpath = "//a[text()='Payslip']")
	WebElement paySlip;
		
	@FindBy(xpath = "//a[text()='Invoice']")
	WebElement invoice;
	
	@FindBy(xpath = "//a[text()='Report']")
	WebElement report;
	
	

	public String verifyLoggedInUser() {
		return objGeneralUtilities.getTextForAnElement(loggedinUser);

	}
	public void navigateToWorkersPage() {
		workersTab.click();
		
		
	}
	public void navigateToClientsPage() {
		clientsTab.click();
		
		
	}
	
}
