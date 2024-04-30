package com.qabible.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qabible.elementrepository.HomePage;
import com.qabible.elementrepository.LoginPage;
import com.qabible.elementrepository.UpdateWorkerPage;
import com.qabible.elementrepository.WorkersPage;

import base.BaseClass;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class WorkersTestCases extends BaseClass {
	LoginPage objLoginPage;
	HomePage objHomePage;
	WorkersPage objWorkersPage;
	ExcelRead objExcelRead = new ExcelRead("src/main/resources/TestData.xlsx");
	UpdateWorkerPage objectUpdateWorkerPage = new UpdateWorkerPage(driver);
	@Test(enabled = false)
	public void verifyTheBackgroudColorOfResetButton() {

		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		String actual = objWorkersPage.getBackgroundColorOfResetButton();
		String expected = "#ffffff";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "There is a mismatch in the background colors");
	}

	@Test(enabled = false)
	public void verifyTheTextOfSearchButton() {

		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		String actual = objWorkersPage.getTextForSearchButton();
		String expected = "Search";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "The text doesnot match");
	}

	@Test(enabled = false)
	public void verifyTheToolTipOfDeleteIcon() {
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		String actual = objWorkersPage.getToolTipOfDeleteIcon();
		System.out.println(actual);
		String expected = "Delete";
		Assert.assertEquals(actual, expected, "The Tool tip value is not as expected ");
	}

	@DataProvider
	public Object[][] getFormData() {
		return objExcelRead.getTestData("SearchData");
	}

	@Test(dataProvider = "getFormData")
	public void verifySearchForWorker(String firstName, String middleName, String lastName, String postCode,
			String niNumber) {
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		objWorkersPage.inputFirstNameToSearchBox(firstName);
		objWorkersPage.inputLastNameToSearchBox(lastName);
		objWorkersPage.inputPostCodeToSearchBox(postCode);
		objWorkersPage.inputNiNumberToSearchBox(niNumber);
		objWorkersPage.clickSearchButton();
		try {
		    Thread.sleep(3000); // Wait for 3 seconds (adjust the time as needed)
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		String actual = objWorkersPage.getDataInTheNameFieldOfTheResultTable();
		String expected = objWorkersPage.getExpectedFullName(firstName, middleName, lastName);
		Assert.assertEquals(actual, expected, "Search was unsuccessfull");
	}
	@DataProvider
	public Object[][] getDataForResetButtonTestFromExcel()
	{
		return objExcelRead.getTestData("ResetData");
	}

	@Test(dataProvider = "getDataForResetButtonTestFromExcel",enabled = false)
	public void verifyWorkingOfResetButton(String firstName, String lastName, String postCode, String niNumber) {
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		objWorkersPage.inputFirstNameToSearchBox(firstName);
		objWorkersPage.inputLastNameToSearchBox(lastName);
		objWorkersPage.inputPostCodeToSearchBox(postCode);
		objWorkersPage.inputNiNumberToSearchBox(niNumber);
		objWorkersPage.clickResetButton();
		String val1 = objWorkersPage.getValueFromFirstNameField();
		String val2 = objWorkersPage.getValueFromLastNameField();
		String val3 = objWorkersPage.getValueFromPostCodeField();
		String val4 = objWorkersPage.getValueFromNiNumberField();
		boolean condition1 = val1.isEmpty();
		boolean condition2 = val2.isEmpty();
		boolean condition3 = val3.isEmpty();
		boolean condition4 = val4.isEmpty();
		Assert.assertTrue(condition1, "First Name Reset Failed");
		Assert.assertTrue(condition2, "Last Name Reset Failed");
		Assert.assertTrue(condition3, "PostCode Reset Failed");
		Assert.assertTrue(condition4, "NiNumber Reset Failed");
	}
	@Test(enabled = false)
	public void verifyUpdateIconSuccessfullyNavigatesToUpdatePage() {
		int row_to_be_checked_for_updation = 1;
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		objWorkersPage.clickOnUpdateIconOnAnyRow(row_to_be_checked_for_updation);
		String name = objectUpdateWorkerPage.getValueFromTheFirstNameFieldOrKnownNameField();
		String expected =  "UPDATE WORKER: "+name;
		String actual = objectUpdateWorkerPage.getHeaderForThePage();
		Assert.assertEquals(actual, expected,"Header not matching so navigation unsuccessfull");
			
	}
	
}
