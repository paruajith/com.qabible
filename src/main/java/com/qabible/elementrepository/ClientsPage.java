package com.qabible.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ClientsPage {

	WebDriver driver;
	GeneralUtilities objGeneralUtilities = new GeneralUtilities();
	WaitUtility objectWaitUtility = new WaitUtility();

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Clients']")
	WebElement headerClients;

	@FindBy(id = "clientsearch-id")
	WebElement clientIdField;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//table//tr[1]//td[1]")
	WebElement clientIdColumnFromResultTable;

	public String getHeader() {
        objectWaitUtility.waitUntilDesiredTextAppears(driver, headerClients,"CLIENTS");
		return objGeneralUtilities.getHeaderTextForElement(headerClients);
	}

	public void inputValueToClientIdField(int i) {
		clientIdField.sendKeys(String.valueOf(i));
	}

	public void clickOnTheSearchButton() {
		searchButton.click();
	}

	public String getValueFromTheClientIdColumnOfTheResultTable() {
		return objGeneralUtilities.getAttributeValueForAnElement(clientIdColumnFromResultTable, "value");
	}

}
