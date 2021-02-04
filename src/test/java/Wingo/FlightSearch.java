package Wingo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Objects;
import resources.Base;

public class FlightSearch extends Base {
	Properties prop = new Properties();
	Objects lpObjects = new Objects(driver);
	public static Logger log = LogManager.getLogger(FlightSearch.class.getName());

	@BeforeTest
	public void openBrowser() throws IOException {
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(fis);
		String baseURL = prop.getProperty("BaseURL");
		driver = initializeDriver();
		driver.get(baseURL);
		log.info(baseURL + " loaded");
	}

	@Test
	public void avalidateHomepage() throws InterruptedException, MalformedURLException, IOException {
		// Objects lpObjects = new Objects(driver);
		Thread.sleep(3000);

		String currentURL = driver.getCurrentUrl();
		HttpURLConnection conn = (HttpURLConnection) new URL(currentURL).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();

		Assert.assertEquals(400, respCode);
		

		log.info("Response Code is " + respCode);
	

	}

	@Test
	public void searchFlight() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(fis);
		String originCity = prop.getProperty("OriginCity");
		String destinationCity = prop.getProperty("DestinationCity");

		Objects lpObjects = new Objects(driver);

		lpObjects.oneWayTrip().click();
		lpObjects.originCity().click();
		lpObjects.originCityBox().sendKeys(originCity);
		lpObjects.originCityCombo().click();
		lpObjects.destinyCity().sendKeys(destinationCity);
		lpObjects.destinyCityCombo().click();
		lpObjects.date().click();
		Thread.sleep(3000);
		log.info("Destination selected");
	}

	@Test
	public void selectFare() throws InterruptedException {
		Objects lpObjects = new Objects(driver);
		String ParentWindowHandle = driver.getWindowHandle();
		// System.out.println("ParentWindowHandle " + ParentWindowHandle);
		Assert.assertTrue(lpObjects.searchButton().isEnabled());
		lpObjects.searchButton().click();

		// System.out.println(driver.getCurrentUrl());

		for (String childTab : driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}

		Thread.sleep(3000);

		// System.out.println(driver.getCurrentUrl());

		lpObjects.goBasic().click();
		Thread.sleep(1000);
		Assert.assertTrue("Continue!", lpObjects.continueButton().isEnabled());
		log.info("Fare selected");
		lpObjects.continueButton().click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
