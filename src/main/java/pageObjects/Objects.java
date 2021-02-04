package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objects {
	public WebDriver driver;

	public Objects(WebDriver driver) {
		this.driver = driver;
	}

	By homeButton = By.xpath("/div[2]/section[2]/div/div/a/img");

	By manageYourTrip = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a");
	By manageYourTripTitle = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/div/article/h2");
	By oneWayTrip = By.id("btnIda");
	By originCity = By.xpath("//*[@id=\"ibeTab\"]/div[1]/div/div/div[3]/div/div/div[1]/div[2]/div/div/div");
	By originCityBox = By.id("inputOrigen");
	By originCityCombo = By.id("comboOrigen");
	By destinyCity = By.id("inputDestino");
	By destinyCityCombo = By.xpath("//*[@id=\"comboDestino\"]/li");
	By date = By.xpath("//*[@id=\"inputOutboundDate\"]/div[3]/div[2]/div/div/table[2]/tbody/tr[4]/td[7]/div");
	By searchButton = By.xpath(
			"/html/body/div/main/section/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/div/div[3]/div/div[2]/div/div[5]/div");

	By goBasic = By.xpath(
			"//*[@id=\"vuelos-ida\"]/div/div/div[2]/div/div/div[1]/div/div[1]/div/label");
	By continueButton = By.xpath("/html/body/app-root/div[1]/app-step/main/app-ofertsemanal/div[3]/main/div[8]/button");
	By names = By.id("name-ad-1");
	By lastnames = By.id("lastname-ad-1");
	By gender = By.cssSelector(".styledSelect");

	public WebElement homeButton() {
		return driver.findElement(homeButton);
	}

	public WebElement manageYourTrip() {
		return driver.findElement(manageYourTrip);
	}

	public WebElement manageYourTripTitle() {
		return driver.findElement(manageYourTripTitle);
	}

	public WebElement oneWayTrip() {
		return driver.findElement(oneWayTrip);
	}

	public WebElement originCity() {
		return driver.findElement(originCity);
	}

	public WebElement originCityBox() {
		return driver.findElement(originCityBox);
	}

	public WebElement originCityCombo() {
		return driver.findElement(originCityCombo);
	}

	public WebElement destinyCity() {
		return driver.findElement(destinyCity);
	}

	public WebElement destinyCityCombo() {
		return driver.findElement(destinyCityCombo);
	}

	public WebElement date() {
		return driver.findElement(date);
	}

	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement goBasic() {
		return driver.findElement(goBasic);
	}

	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
}
