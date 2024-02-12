package insuranceCalculation_MotoCycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObject;
import testBase.TestBase;

public class ErrorTests_MotorCycle extends TestBase {

	//testng
	
	@Test(enabled = false)
	public void errorMessage_payloadField() {
		//open browser navigate -->
		//click on motorcycle link -- present on home page
		 
		homepage.clickonMotorcyclelink();
		//enter cylinder capacity
		vehicledata.enterCylinderCapacity("3333");
		test.log(Status.PASS, "Cylinder capacity is filled with data : 3333");
		//verify error message
		String actualErrorMessage =vehicledata.getErrorMessageonCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 3000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"Error Message is not as expected on cylinder capacity");
	}
	@Test(enabled = true)
	public void verifyModelDropDownOptions() {
		//click on motorcyle link
		homepage.clickonMotorcyclelink();
		//get dropdown content
		List <String> actualValues = vehicledata.getDropownOptionModel();
		test.log(Status.INFO,"The actual DD values present are " +actualValues);
		//expected values
		List <String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped", "Motorcycle");
		test.log(Status.INFO,"The expected DD values present are " +expectedValues);
		//compare 
		Assert.assertEquals(actualValues, expectedValues,"Error in Dropdown options compare");
		
	}
	
}
