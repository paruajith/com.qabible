package com.qabible.elementrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class WorkersPage {
	WebDriver driver;
	GeneralUtilities objGeneralUtilities = new GeneralUtilities();
	WaitUtility objectWaitUtility = new WaitUtility();

	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement resetButton;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorkerLink;

	@FindBy(xpath = "//table//tr[1]//td[8]//a[@title='Delete']")
	WebElement deleteIconLocator;

	@FindBy(xpath = "//h1[text()='Workers']")
	WebElement headerWorkers;

	@FindBy(id = "workersearch-first_name")
	WebElement firstNameSearchBox;

	@FindBy(id = "workersearch-last_name")
	WebElement lastNameSearchBox;

	@FindBy(id = "workersearch-postcode")
	WebElement postCodeSearchBox;

	@FindBy(id = "workersearch-ni_number")
	WebElement niNumberSearchBox;

	@FindBy(xpath = "//table//tr[1]//td[2]")
	WebElement dataInTheNameField;

	public String getTextForSearchButton() {
		return objGeneralUtilities.getTextForAnElement(searchButton);
	}

	public String getBackgroundColorOfResetButton() {
		return objGeneralUtilities.getCssValueOfTheButton(resetButton, "background-color");
	}

	public void clickOnCreateWorkerLink() {
		
		objectWaitUtility.waitForThePresenceOfAnElement("//a[text()='Create Worker']",driver);
		createWorkerLink.click();
	}

	public String getToolTipOfDeleteIcon() {
		return objGeneralUtilities.getAttributeValueForAnElement(deleteIconLocator, "title");
	}

	public String getHeaderText() {
		objectWaitUtility.waitUntilDesiredTextAppears(driver, headerWorkers,"WORKERS");
		return objGeneralUtilities.getHeaderTextForElement(headerWorkers);
	}

	public void inputFirstNameToSearchBox(String firstName) {
		firstNameSearchBox.sendKeys(firstName);
	}

	public void inputLastNameToSearchBox(String lastName) {
		lastNameSearchBox.sendKeys(lastName);
	}

	public void inputPostCodeToSearchBox(String postCode) {
		postCodeSearchBox.sendKeys(postCode);
	}

	public void inputNiNumberToSearchBox(String niNumber) {
		niNumberSearchBox.sendKeys(niNumber);
	}

	public void clickSearchButton() {
		
		searchButton.click();
		objGeneralUtilities.mediumDelay();
	}

	public String getDataInTheNameFieldOfTheResultTable() {
		objectWaitUtility.waitForThePresenceOfAnElement("//table//tr[1]//td[2]", driver);
		return dataInTheNameField.getText();
	}

	public void clickResetButton() {
		resetButton.click();
	}

	public String getValueFromFirstNameField() {
		return objGeneralUtilities.getAttributeValueForAnElement(firstNameSearchBox, "value");
	}

	public String getValueFromLastNameField() {
		return objGeneralUtilities.getAttributeValueForAnElement(lastNameSearchBox, "value");
	}

	public String getValueFromPostCodeField() {
		return objGeneralUtilities.getAttributeValueForAnElement(postCodeSearchBox, "value");
	}

	public String getValueFromNiNumberField() {
		return objGeneralUtilities.getAttributeValueForAnElement(niNumberSearchBox, "value");
	}

	public void clickOnUpdateIconOnAnyRow(int row_to_be_checked_for_updation) {
		PageFactory.initElements(driver, this);
	    String xpath = "//table//tr[" + row_to_be_checked_for_updation + "]//td[8]//a[@title='Update']";
	    WebElement updateIconLocator = driver.findElement(By.xpath(xpath));
	    
	    updateIconLocator.click();
	}
	public String getExpectedFullName(String firstName, String middleName, String lastName) {
        String expected;
        if (middleName.contentEquals("")) {
            expected = firstName + " " + lastName;
        } else {
            expected = firstName + " " + middleName + " " + lastName;
        }
        return expected;
    }
	

}
