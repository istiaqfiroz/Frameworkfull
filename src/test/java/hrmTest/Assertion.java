package hrmTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObject.HomePage;
import pageObject.WelcomePage;
import resources.Base;

public class Assertion extends Base {
	
	
	Logger logger = LogManager.getLogger(Assertion.class);
	
	
	@Test
	public void loginHRM() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("urlHRM"));
		logger.info("driver initialize");
		HomePage hp = new HomePage(driver);
		
		hp.getAdmin().sendKeys("Admin");
		hp.getPassword().sendKeys("admin123");
		hp.getSubmit().click();
		logger.info("Succcefully Login");
		WelcomePage wp = new WelcomePage(driver);
		String title = wp.getTitle().getText();
		AssertJUnit.assertEquals(title, "Paul Colling");
		logger.info("Match with title");
		driver.close();
		logger.info("Succefully driver close");
		
}
}