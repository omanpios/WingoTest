package Wingo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Objects;
import resources.Base;

public class ManageYourTrip extends Base {
	Properties prop = new Properties();
	public static Logger log = LogManager.getLogger(ManageYourTrip.class.getName());
	public String nameofCurrMethod = new Exception().getStackTrace()[0].getMethodName();

	@BeforeTest
	public void openBrower() throws IOException {
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(fis);
		String baseURL = prop.getProperty("BaseURL");
		driver = initializeDriver();
		driver.get(baseURL);
		log.info(baseURL +" loaded");
	}

	@Test
	public void manageYourTrip() {
		Objects lpObjects = new Objects(driver);
		lpObjects.manageYourTrip().click();
		AssertJUnit.assertTrue(lpObjects.manageYourTripTitle().isDisplayed());
		log.info(lpObjects.manageYourTripTitle().getText() + " is displayed");
	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
