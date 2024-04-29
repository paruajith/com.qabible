package com.qabible.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class CreateWorkerPage {

	GeneralUtilities objGeneralUtilities = new GeneralUtilities();

	WebDriver driver;

	public CreateWorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "worker-title")
	WebElement createWorkerTitleField;

	@FindBy(id = "worker-first_name")
	WebElement firstName;

	@FindBy(id = "worker-last_name")
    WebElement lastName;

	@FindBy(id = "worker-phone")
	WebElement phone;

	@FindBy(id = "worker-mobile")
	WebElement mobile;

	@FindBy(id = "worker-email")
	WebElement email;

	@FindBy(id = "worker-gender")
	WebElement gender;

	@FindBy(id = "worker-middle_name")
	WebElement middleName;

	@FindBy(id = "worker-dob")
	WebElement dob;

	@FindBy(id = "worker-address1")
	WebElement address1;

	@FindBy(id = "worker-address2")
	WebElement address2;

	@FindBy(id = "worker-address3")
	WebElement address3;

	@FindBy(id = "worker-postcode")
	WebElement postCode;

	@FindBy(id = "worker-branch_id")
	WebElement branchId;

	@FindBy(id = "worker-division_id")
	WebElement division;

	@FindBy(id = "worker-employment_type")
	WebElement employmentType;

	@FindBy(id = "worker-payslip_method")
	WebElement paySlipMethod;

	@FindBy(id = "worker-engage_status")
	WebElement engageStatus;

	@FindBy(id = "worker-ni_number")
	WebElement niNumber;

	@FindBy(id = "worker-country")
	WebElement country;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextButton;

	public String selectValueFromTheTitleDropDownAndGetSelectedValue() {
		return objGeneralUtilities.getTheSelectedValueFromTheDropDown(createWorkerTitleField, "Mrs");

	}
	public void clickOnNextButton() {
		
		nextButton.click();
		
	}
	public void inputValueToTheTitleField(String title) {
		createWorkerTitleField.sendKeys(title);
	}
	public void inputValueToTheFirstNameField(String firstName2) {
		firstName.sendKeys(firstName2);
		
	}
	public void inputValueToTheLastNameField(String lastName2) {
		lastName.sendKeys(lastName2);
		
	}
	public void inputValueToThePhoneField(String phone2) {
		phone.sendKeys(phone2);
		
	}
	public void inputValueToTheMobileField(String mobile2) {
		mobile.sendKeys(mobile2);
		
	}
	public void inputValuToTheEmailField(String email2) {
		email.sendKeys(email2);
		
	}
	public void inputValueToTheGenderField(String gender2) {
		gender.sendKeys(gender2);
	}
	public void inputValueToTheMiddleNameField(String middleName2) {
		middleName.sendKeys(middleName2);
		
	}
	public void inputValueToTheDobField(String dateOfBirth) {
		dob.sendKeys(dateOfBirth);
		
	}
	public void inputValueToTheAddressLine1Field(String addressLine1) {
		address1.sendKeys(addressLine1);
		
	}
	public void inputValueToTheAddressLine2Field(String addressLine2) {
		address2.sendKeys(addressLine2);
	}
	public void inputValueToTheAddressLine3Field(String addressLine3) {
		address3.sendKeys(addressLine3);
		
	}
	public void inputValueToThePostCodeField(String postCode2) {
		postCode.sendKeys(postCode2);
		
	}
	public void inputValueToTheBranchField(String branch) {
		branchId.sendKeys(branch);
		
	}
	public void inputValueToTheDivisionField(String division2) {
		division.sendKeys(division2);
		
	}
	public void inputValueToTheEmploymentTypeField(String employmentType2) {
		employmentType.sendKeys(employmentType2);
		
	}
	public void inputValueToThePayslipMethodField(String payslipMethod2) {
		paySlipMethod.sendKeys(payslipMethod2);
		
	}
	public void inputValueToTheEngagestatusField(String engageStatus2) {
		engageStatus.sendKeys(engageStatus2);
		
	}
	public void inputValueToTheNiNumberField(String niNumber2) {
		niNumber.sendKeys(niNumber2);
		
	}
	public void inputValueToTheCountryField(String country2) {
		country.clear();
		country.sendKeys(country2);
		
	}

}
