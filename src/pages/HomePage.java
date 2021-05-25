package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	By marqueeWelcome = By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]");
	By welcomeManagerId = By.xpath("//table//table/tbody/tr[3]/td");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMarquee() {
		return(driver.findElement(marqueeWelcome));
	}
	
	public String getWelcomeIdText() {
		return(driver.findElement(welcomeManagerId).getText());
	}

}
