package insuranceCalculation_MotoCycle;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import resuableComponents.ExcelOperations;
import testBase.TestBase;

public class EndtoEndTestcases_MotorCycle_HashMap extends TestBase {
	
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	@Test
	public void insuranceCalculate_volvo() throws Exception {
		HashMap<String, String> testData = excel.getTestDataInMap(1) ;
		test.log(Status.INFO,"Test data used for execution are " +testData);
		System.out.println("TestData is "+testData);
		homepage.clickonMotorcyclelink();
		vehicledata.enterVehicleData(testData);
		vehicledata.clickOnNextButton();
		insurantData.EnterInsurantData(testData);
		insurantData.clickOnNextButton();
		productData.enterProductData(testData);
		productData.clickOnNextButton();
		//String ExpectedSilverPrice = "241.00";
		
		//String ActualSilverPrice = priceOptions.getPriceForSelectedOption("Silver");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Gold"),testData.get("PriceValidation_Gold"),"Price is missmatched");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Silver"),testData.get("PriceValidation_Silver"),"Price is missmatched");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Platinum"),testData.get("PriceValidation_Platinum"),"Price is missmatched");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Ultimate"),testData.get("PriceValidation_Ultimate"),"Price is missmatched");
		priceOptions.selectPriceOption(testData.get("SelectOption"));
		priceOptions.clickNextButton();
		
	}
	
	
	
	@Test
	public void insuranceCalculate_ford() throws Exception {
		HashMap<String, String> testData = excel.getTestDataInMap(2) ;
		test.log(Status.INFO,"Test data used for execution are " +testData);
		System.out.println("TestData is "+testData);
		homepage.clickonMotorcyclelink();
		vehicledata.enterVehicleData(testData);
		vehicledata.clickOnNextButton();
		insurantData.EnterInsurantData(testData);
		insurantData.clickOnNextButton();
		productData.enterProductData(testData);
		productData.clickOnNextButton();
		//String ExpectedSilverPrice = "241.00";
		
		//String ActualSilverPrice = priceOptions.getPriceForSelectedOption("Silver");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Gold"),testData.get("PriceValidation_Gold"),"Price is missmatched");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Silver"),testData.get("PriceValidation_Silver"),"Price is missmatched");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Platinum"),testData.get("PriceValidation_Platinum"),"Price is missmatched");
		Assert.assertEquals( priceOptions.getPriceForSelectedOption("Ultimate"),testData.get("PriceValidation_Ultimate"),"Price is missmatched");
		priceOptions.selectPriceOption(testData.get("SelectOption"));
		priceOptions.clickNextButton();
		
	}
	
}
