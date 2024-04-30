package com.qabible.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qabible.elementrepository.HomePage;
import com.qabible.elementrepository.LoginPage;

import base.BaseClass;
import constant.Constant;
import utilities.ExcelRead;

public class LoginTestcases extends BaseClass {

	// testBasic();

	ExcelRead objectExcelRead = new ExcelRead("src/main/resources/TestData.xlsx");
	LoginPage objLoginPage;
	HomePage objHomePage;

	@Test(groups = "critical", retryAnalyzer = retry.Retry.class)
	public void verifyLoginInWithValidUser() throws IOException {

		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);

		objLoginPage.inputUserName(objectExcelRead.getStringData("login_data", 2, 0));
		objLoginPage.inputPassWord(objectExcelRead.getStringData("login_data", 2, 1));
		objLoginPage.clickOn_LoginButton();
		objectExcelRead.getTestData("testdata");
		String actual = objHomePage.verifyLoggedInUser();
		String expected = "CAROL THOMAS";
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedLogin);

	}

	public void verifyLoginWithInvalidUser() throws IOException {

		objLoginPage.inputUserName(objectExcelRead.getStringData("login_data", 3, 0));
		objLoginPage.inputPassWord(objectExcelRead.getStringData("login_data", 3, 1));
		objLoginPage.clickOn_LoginButton();
		String actual = objLoginPage.getTextOfLoginError();
		String expected = "Incorrect username or password.";
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedInvalidLogin);

	}
}