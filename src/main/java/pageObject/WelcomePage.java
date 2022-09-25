package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
	WebDriver driver;
	By title = By.className("oxd-userdropdown-name");
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
