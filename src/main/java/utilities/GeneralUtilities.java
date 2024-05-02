package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {

	public String getTextForAnElement(WebElement element) {
		String stringText = element.getText();
		return stringText;
	}

	public String getCssValueOfTheButton(WebElement element, String propertyName) {
		String cssPropertyValueOfButton = element.getCssValue(propertyName);
		return Color.fromString(cssPropertyValueOfButton).asHex();

	}

	public String getTheSelectedValueFromTheDropDown(WebElement element, String valueToBeSelected) {
		Select objectSelect = new Select(element);
		objectSelect.selectByVisibleText(valueToBeSelected);
		WebElement selectedElement = objectSelect.getFirstSelectedOption();
		String selectedValueFromDropDown = selectedElement.getText();
		return selectedValueFromDropDown;
	}

	public String getAttributeValueForAnElement(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getHeaderTextForElement(WebElement element) {

		return element.getText();

	}
	public void functionToScrollDownTheWindow(WebDriver driver,int x,int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
		
	}
	public void mediumDelay() {
		try {
		    Thread.sleep(2000); // Wait for 3 seconds (adjust the time as needed)
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
	}
}
