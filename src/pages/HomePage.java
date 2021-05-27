package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	By titleHomePage = By.tagName("title");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitleHomePage() {
		return(driver.findElement(titleHomePage).getAttribute("textContent"));
	}
	
	public void verifyTitleHomePage() {
		String strActualTitle = getTitleHomePage().trim();
		String strExpectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(strActualTitle, strExpectedTitle);
	}
}
