package com.qabible.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities objGeneralUtilities = new GeneralUtilities();
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="loginform-username")
	WebElement userNameField;
	
	@FindBy(id="loginform-password")
	WebElement passWordField;
	
	@FindBy(xpath="//button[@name='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[text()='Incorrect username or password.']")
	WebElement errorMessage;
	
	
	public void inputUserName(String user_name) {
		userNameField.sendKeys(user_name);
		
	}
	public void inputPassWord(String pass_word) {
		passWordField.sendKeys(pass_word);
		
	}
	public void clickOn_LoginButton() {
		loginButton.click();
		
	}
	
	public String getTextOfLoginError() {
	return objGeneralUtilities.getTextForAnElement(errorMessage);
	}

}
