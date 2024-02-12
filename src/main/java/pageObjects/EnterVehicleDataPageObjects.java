package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {

	@FindBy(id="make")
	WebElement dd_make;
	
	@FindBy(xpath="//select[@id='model']")
	WebElement dd_model;
	
	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;
	
	@FindBy(xpath="//input[@id='engineperformance']")
	WebElement txt_engineperformance;

	@FindBy(xpath="//input[@id='dateofmanufacture']")
	WebElement txt_dateofmanufacture;
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;
	
	@FindBy(id="listprice")
	WebElement txt_listprice;
	
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	@FindBy(id="nextenterinsurantdata")
	WebElement txt_nextenterinsurancedata;
	
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cylindercapacity;
	
	
	
	
	//constructor
	public EnterVehicleDataPageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public void enterCylinderCapacity(String cylindercap) {
		txt_cylindercapacity.sendKeys(cylindercap);
	}
	public String getErrorMessageonCylinderCapacity() {
		return error_cylindercapacity.getText();
		
	}
	public List<String> getDropownOptionModel() {
		return cm.getDropDownFromAlist(dd_model);
	}
	public List<String> getDropownOptionMake() {
		return cm.getDropDownFromAlist(dd_make);
	}
	public void enterVehicleData(HashMap<String,String>testData) throws Exception {
		cm.selectDropDownOption(dd_make, testData.get("Vehicle_Make"));
		cm.selectDropDownOption(dd_model, testData.get("Vehicle_Model"));
		txt_cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
		txt_engineperformance.sendKeys(testData.get("Vehicle_Enging Performance"));
		txt_dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		cm.selectDropDownOption(dd_numberofseats,testData.get("Vehicle_No of Seats_motorcycle"));
		txt_listprice.sendKeys(testData.get("Vehicle_List Price"));
		txt_annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
		
	}
	public void clickOnNextButton() {
		txt_nextenterinsurancedata.click();
	}
}
