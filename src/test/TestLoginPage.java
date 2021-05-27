package test;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestLoginPage {	
	WebDriver driver;
	LoginPage objLoginPage;
	HomePage objHomePage;
		
	@Test
	public void testLogin() {
		objLoginPage.enterLoginCredentials(PropertyUtil.UserId, PropertyUtil.Password);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("HomePage"));
		objHomePage.verifyTitleHomePage();
	}
	  
	@BeforeMethod
	public void beforeMethod() {
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty(PropertyUtil.DriverName,PropertyUtil.DriverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/V4/");
	}
	
	@AfterClass
	public void afterClass() {
	}
	  
	@BeforeTest
	public void init() throws Exception {
		PropertyUtil.init();
	}
	  
	@AfterTest
	public void afterTest() {
		driver.close();
    }
}
