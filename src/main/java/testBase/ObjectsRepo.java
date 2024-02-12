package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObject;
import pageObjects.SelectPriceOptionsPageObjects;
import resuableComponents.CommonMethods;

public class ObjectsRepo {
	public static WebDriver driver;
	public static HomePageObject homepage; 
	public static EnterVehicleDataPageObjects vehicledata; 
	public static ExtentReports extent;
	public static ExtentTest test;
	public CommonMethods cm = new CommonMethods();
	public static EnterInsurantDataPageObjects insurantData;
	public static EnterProductDataPageObjects productData;
	public static SelectPriceOptionsPageObjects priceOptions;

}
