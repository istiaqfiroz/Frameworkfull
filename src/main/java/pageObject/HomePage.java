package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	By admin = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@type='password']");
	By submit = By.xpath("//button[@type='submit']");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getAdmin() {
		return driver.findElement(admin);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
}
