package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BDhomepage {
	WebDriver driver;
	By deshiShop = By.xpath("//a[@href='https://bongodeshi.com/online-shop/']");
	
	
	public BDhomepage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	
	public WebElement getDeshiShop() {
		return driver.findElement(deshiShop);
	}
}
