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

public class EndtoEndTestcases_MotorCycle extends TestBase {
	
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	@Test(dataProvider = "vehData")
	public void insuranceCalculate(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
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
	
	//DataProvider method return object array
	@DataProvider(name = "vehData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for(int i=1;i<=excel.getRowCount();i++) {
			HashMap<String,String> testData=excel.getTestDataInMap(i);
			obj[i-1][0]= testData;
		}
		return obj;
		
	}
	
	
}
