package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionsPageObjects extends TestBase{
	

	@FindBy(id="nextsendquote") 
	WebElement btn_next;

	//to get price based on seleted plan
	public String getPriceForSelectedOption(String Plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+Plan+"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
		}
	public void selectPriceOption(String Plan) {
		String dataXpath = "//input[@name='Select Option' and @value='"+Plan+"']/parent::label";
		 driver.findElement(By.xpath(dataXpath)).click();
		
	}
	public void clickNextButton() {
		btn_next.click();
	}
    public SelectPriceOptionsPageObjects() {
	// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);
}
}
