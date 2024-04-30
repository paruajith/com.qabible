package com.qabible.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qabible.elementrepository.ClientsPage;
import com.qabible.elementrepository.HomePage;
import com.qabible.elementrepository.LoginPage;
import com.qabible.elementrepository.WorkersPage;

import base.BaseClass;

public class ClientsPageTestcases extends BaseClass{
	  LoginPage objLoginPage;
			HomePage objHomePage;
			ClientsPage objClientsPage;
			WorkersPage objWorkersPage;
  @Test
  public void verifyTheSearchWithOnlyClientId() {
	  objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objWorkersPage = new WorkersPage(driver);
		objLoginPage.inputUserName("carol");
		objLoginPage.inputPassWord("1q2w3e4r");
		objLoginPage.clickOn_LoginButton();
		objHomePage.navigateToClientsPage();
		objClientsPage.inputValueToClientIdField(2);
		objClientsPage.clickOnTheSearchButton();
		String actual = objClientsPage.getValueFromTheClientIdColumnOfTheResultTable();
		String expected = String.valueOf(2);
		Assert.assertEquals(actual, expected, "search not successfull");
		
  }
}
