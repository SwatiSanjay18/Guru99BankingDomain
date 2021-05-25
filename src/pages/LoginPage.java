package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By txtUserId = By.xpath("//input[@name='uid']");
	By txtPassword = By.xpath("//input[@name='password']");
	By btnLogin = By.xpath("//input[@name='btnLogin']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserId(String userId) {
		driver.findElement(txtUserId).sendKeys(userId);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public void enterLoginCredentials(String id, String pwd) {
		enterUserId(id);
		enterPassword(pwd);
		clickOnLogin();
	}
}
