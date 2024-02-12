package testBase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObject;
import pageObjects.SelectPriceOptionsPageObjects;
import resuableComponents.PropertiesOperations;

public class TestBase extends ObjectsRepo {
	
	
public void LaunchBrowserAndNavigate() throws Exception {
	//read properties file get browser and url
	String browser = PropertiesOperations.getPropertyValuesbyKey("browser");
	String url = PropertiesOperations.getPropertyValuesbyKey("url");
	if(browser.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("ie")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
}

@BeforeMethod
public void setupMethod() throws Exception {
	LaunchBrowserAndNavigate();
	homepage =new HomePageObject();
	vehicledata=new EnterVehicleDataPageObjects();
	insurantData = new EnterInsurantDataPageObjects();
	productData = new EnterProductDataPageObjects();
	priceOptions = new SelectPriceOptionsPageObjects();
	}
@AfterMethod
public void cleanup() {
	//driver.quit();
	}

}
