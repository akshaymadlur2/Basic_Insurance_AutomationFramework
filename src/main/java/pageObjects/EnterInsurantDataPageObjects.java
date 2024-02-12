package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsurantDataPageObjects extends TestBase {

	@FindBy(id="firstname")
	WebElement txt_firstname;
	@FindBy(id="lastname")
	WebElement txt_lastname;
	@FindBy(id="birthdate")
	WebElement txt_birthdate;
	//gender
	@FindBy(xpath="//input[@name='Gender']/parent::label")
	List<WebElement> rdo_gender;
	
	@FindBy(id="country")
	WebElement dd_country;
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	@FindBy(id="city")
	WebElement txt_city;
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	//hobbies
	@FindBy(xpath="//input[@name='Hobbies']/parent::label")
	List<WebElement>chk_hobbies;
	@FindBy(id="website")
	WebElement txt_website;
	@FindBy(id="open")
	WebElement btn_PictureOpenButton;
	@FindBy(id="nextenterproductdata")
	WebElement txt_nextenterproductdata;
	
	
	
	public EnterInsurantDataPageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public void EnterInsurantData(HashMap<String,String>testData) throws Exception {
		txt_firstname.sendKeys(testData.get("Insurant_FirstName"));
		txt_lastname.sendKeys(testData.get("Insurant_LastName"));
		txt_birthdate.sendKeys(testData.get("Insurant_birthdate"));
		cm.selectRadioBtnValue(rdo_gender, testData.get("Insurant_gender"));
		cm.selectDropDownOption(dd_country, testData.get("Insurant_country"));
		txt_zipcode.sendKeys(testData.get("Insurant_zipcode"));
		//select dropdown
		cm.selectDropDownOption(dd_occupation, testData.get("Insurant_occupation"));
		//select checkbox
		cm.selectCheckBoxValue(chk_hobbies, testData.get("Insurant_Hobby"));
	}
	public void clickOnNextButton() {
		txt_nextenterproductdata.click();
	}
}
