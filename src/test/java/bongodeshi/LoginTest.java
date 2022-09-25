package bongodeshi;

import org.testng.annotations.Test;

import pageObject.BDhomepage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import resources.Base;

public class LoginTest extends Base{

	@Test
	public void bdLogin() throws IOException, InterruptedException {
		
		
		
			driver = initializeDriver();
			driver.get(prop.getProperty("urlBD"));
			Thread.sleep(2000);
			BDhomepage BDP =new BDhomepage(driver);
			BDP.getDeshiShop().click();
			driver.close();
		
		
	}
}
