package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestLoginPage {	
	WebDriver driver;
	Properties prop;
		
	@Test
	public void f() {
	}
	  
	@BeforeMethod
	public void beforeMethod() {
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
    }
}
