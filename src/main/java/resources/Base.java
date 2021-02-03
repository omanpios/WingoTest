package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("Browser");

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/main/java/resources/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src/main/java/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver2) throws IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyy_hhmmss");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName+"_" + formater.format(calendar.getTime()) +".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
