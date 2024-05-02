package base;

import org.testng.annotations.Test;

import utilities.CaptureScreenshotOnFailure;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Config.properties");
		prop.load(ip);
	}

	
   	@BeforeMethod
   	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException {

		testBasic();

		if (browser.equals("Chrome")) {

			this.driver = new ChromeDriver();

		}

		else if (browser.equals("Firefox")) {
			this.driver = new FirefoxDriver();
		}
		this.driver.get("https://www.qabible.in/payrollapp/site/login");

		this.driver.get(prop.getProperty("baseUrl"));

		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			CaptureScreenshotOnFailure object = new CaptureScreenshotOnFailure();
			object.captureScreenShotForFailedTestcase(this.driver, iTestResult.getName());
		}

		this.driver.close();
	}

}
