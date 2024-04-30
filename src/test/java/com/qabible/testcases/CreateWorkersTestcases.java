package com.qabible.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qabible.elementrepository.BankDetailsPage;
import com.qabible.elementrepository.CreateWorkerPage;
import com.qabible.elementrepository.HomePage;
import com.qabible.elementrepository.LoginPage;
import com.qabible.elementrepository.WorkersPage;

import base.BaseClass;
import utilities.ExcelRead;

public class CreateWorkersTestcases extends BaseClass {

	LoginPage objLoginPage;
	HomePage objHomePage;
	WorkersPage objWorkersPage;
	CreateWorkerPage objCreateWorkerPage;
	ExcelRead objectExcelRead = new ExcelRead("src/main/resources/TestData.xlsx");
	BankDetailsPage objectBankDetailsPage;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Test(enabled = false)
	public void verifySelectedValueFromTitleDropdown() throws IOException {
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objCreateWorkerPage = new CreateWorkerPage(driver);

		objLoginPage.inputUserName(objectExcelRead.getStringData("login_data", 2, 0));
		objLoginPage.inputPassWord(objectExcelRead.getStringData("login_data", 2, 1));
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();

		objWorkersPage.clickOnCreateWorkerLink();
		String actual = objCreateWorkerPage.selectValueFromTheTitleDropDownAndGetSelectedValue();
		String expected = "Mrs";
		Assert.assertEquals(actual, expected, "The selected entry is not matching");

	}

	@DataProvider
	public Object[][] getFormData() {
		Object[][] exceldata = objectExcelRead.getTestData("testdata");
		return exceldata;
	}

	//@BeforeClass
	//public void setUp() {
	//	objCreateWorkerPage = PageFactory.initElements(driver, CreateWorkerPage.class);

	//}

	@Test(dataProvider = "getFormData")
	public void testCreateWorkerFormAndNavigationToBankDetailsPage(String title, String firstName, String lastName,
			String phone, String mobile, String email, String gender, String middleName, String dateOfBirth,
			String addressLine1, String addressLine2, String addressLine3, String postCode, String Branch,
			String Division, String employmentType, String payslipMethod, String engageStatus, String niNumber,
			String Country) throws IOException {

		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objCreateWorkerPage = new CreateWorkerPage(driver);
		objectBankDetailsPage = new BankDetailsPage(driver);
		objLoginPage.inputUserName(objectExcelRead.getStringData("login_data", 2, 0));
		objLoginPage.inputPassWord(objectExcelRead.getStringData("login_data", 2, 1));
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		objWorkersPage.clickOnCreateWorkerLink();
		objCreateWorkerPage.inputValueToTheTitleField(title);
		objCreateWorkerPage.inputValueToTheFirstNameField(firstName);
		objCreateWorkerPage.inputValueToTheLastNameField(lastName);
		objCreateWorkerPage.inputValueToThePhoneField(phone);
		objCreateWorkerPage.inputValueToTheMobileField(mobile);
		objCreateWorkerPage.inputValuToTheEmailField(email);
		objCreateWorkerPage.inputValueToTheGenderField(gender);
		objCreateWorkerPage.inputValueToTheMiddleNameField(middleName);
		objCreateWorkerPage.inputValueToTheDobField(dateOfBirth);
		objCreateWorkerPage.inputValueToTheAddressLine1Field(addressLine1);
		objCreateWorkerPage.inputValueToTheAddressLine2Field(addressLine2);
		objCreateWorkerPage.inputValueToTheAddressLine3Field(addressLine3);
		objCreateWorkerPage.inputValueToThePostCodeField(postCode);
		objCreateWorkerPage.inputValueToTheBranchField(Branch);
		objCreateWorkerPage.inputValueToTheDivisionField(Division);
		objCreateWorkerPage.inputValueToTheEmploymentTypeField(employmentType);
		objCreateWorkerPage.inputValueToThePayslipMethodField(payslipMethod);
		objCreateWorkerPage.inputValueToTheEngagestatusField(engageStatus);
		objCreateWorkerPage.inputValueToTheNiNumberField(niNumber);
		objCreateWorkerPage.inputValueToTheCountryField(Country);
		objCreateWorkerPage.clickOnNextButton();
		String actual = objectBankDetailsPage.returnFullPageHeader();
		String expected = "WORKER BANK DETAILS:" + " " + firstName.toUpperCase() + " " + middleName + " "
				+ lastName.toUpperCase();
		Assert.assertEquals(actual, expected, "The Page navigation is not successfull");

	}
}
