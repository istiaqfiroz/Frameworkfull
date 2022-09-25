package hrmTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import resources.Base;

public class Login extends Base{

	
	Logger logger = LogManager.getLogger(Assertion.class);
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider = "getData")
	public void loginHRM(String admin, String password) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("urlHRM"));
		logger.info("driver initialize");
		
		HomePage hp = new HomePage(driver);
		
		hp.getAdmin().sendKeys("Admin");
		hp.getPassword().sendKeys("admin123");
		hp.getSubmit().click();
		logger.info("Succcefully Login");
		
		driver.close();
		logger.info("Succefully driver close");
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		/*Object [][] data = new Object[2][2];
		
		data[0][0]="Admin";
		data[0][1]="admin123";
		data[1][0]="Admin";
		data[1][1]="passward";
		return data;*/
		
		//reading the data from excel
		Object[][] data = new Object[3][2];
		FileInputStream fs = new FileInputStream("/Users/efat/testworkbench/Framework3/ExelFile/POI.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet =wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		for(int i = 1; i<rowCount-1;i++) {
			
			row = sheet.getRow(i+1);
			for(int j= 1; j<colCount; j++) {
				
				XSSFCell cell= row.getCell(j);
				data[i][j]= formatter.formatCellValue(cell);
			}
		}
	return data;
	
}
}
