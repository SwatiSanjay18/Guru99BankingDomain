package test;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLoginPage {	
	WebDriver driver;
	Properties prop;
	LoginPage objLoginPage;
	HomePage objHomePage;
		
	@Test
	public void testLogin() {
		String id = prop.getProperty("userId");
		String pwd = prop.getProperty("password");
		objLoginPage.enterLoginCredentials(id, pwd);
		WebElement weMarquee = objHomePage.getMarquee();
		String welcomeIdText = objHomePage.getWelcomeIdText();
		Assert.assertTrue((weMarquee != null) && (welcomeIdText.contains("Manger Id :")));
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
		System.setProperty(prop.getProperty("driverName"), prop.getProperty("driverPath"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/V4/");
	}
	
	@AfterClass
	public void afterClass() {
	}
	  
	@BeforeTest
	public void init() throws Exception {
		File propFile = new File("data.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop = new Properties();
		prop.load(fis);
	}
	  
	@AfterTest
	public void afterTest() {
		driver.close();
    }
}
