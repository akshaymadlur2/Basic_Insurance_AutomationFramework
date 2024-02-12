package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObject extends TestBase {
	//WebDriver driver = new ChromeDriver();
	//WebElement linkAutomobile = driver.findElement(By.xpath(""));// without page factory
	
	@FindBy(id="nav_automobile") 
	WebElement linkAutomobile;
	
	@FindBy(id="nav_truck") 
	WebElement linkTruck;

	@FindBy(id="nav_camper") 
	WebElement linkCamper;
	@FindBy(id="nav_motorcycle") 
	WebElement link_motorcycle;
	
	
	//use Constructor to use Init Element method
	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}
	public void clickonMotorcyclelink() {
		link_motorcycle.click();
		
	}
	
	
	
}
