package com.qabible.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qabible.elementrepository.ClientsPage;
import com.qabible.elementrepository.HomePage;
import com.qabible.elementrepository.LoginPage;
import com.qabible.elementrepository.WorkersPage;

import base.BaseClass;
import constant.Constant;
import utilities.ExcelRead;

public class HomePageTestCases extends BaseClass {

	ExcelRead objectExcelRead = new ExcelRead("src/main/resources/TestData.xlsx");
	LoginPage objLoginPage;
	HomePage objHomePage;
	WorkersPage objWorkersPage;
	WebDriverWait wait;
	ClientsPage objClientsPage;

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyNavigationBarWorkersLink() throws IOException {

		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName(objectExcelRead.getStringData("login_data", 2, 0));
		objLoginPage.inputPassWord(objectExcelRead.getStringData("login_data", 2, 1));
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToWorkersPage();
		try {
		    Thread.sleep(3000); // Wait for 3 seconds (adjust the time as needed)
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		String actual = objWorkersPage.getHeaderText();
		String expected = "WORKERS";
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedNavigation);

	}
	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyNavigationBarClientsLink() throws IOException {

		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objClientsPage = new ClientsPage(driver);
		objLoginPage.inputUserName(objectExcelRead.getStringData("login_data", 2, 0));
		objLoginPage.inputPassWord(objectExcelRead.getStringData("login_data", 2, 1));
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToClientsPage();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String actual = objClientsPage.getHeader();
		String expected = "CLIENTS";
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedNavigation);

	}
}
