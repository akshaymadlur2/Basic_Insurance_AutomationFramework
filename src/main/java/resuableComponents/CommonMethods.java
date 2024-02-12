package resuableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	//get drown down options as a list
	public List<String> getDropDownFromAlist(WebElement element) {
		Select os = new Select(element);
		List <WebElement>list_webelement_model=os.getOptions();
		List<String> actual_Contents = new ArrayList<String>();
		for (WebElement ref : list_webelement_model) {
			actual_Contents.add(ref.getText());
		}
		return actual_Contents;
	}
	//common method to select dropdown
	public void selectDropDownOption(WebElement element,String ValueTobeSelected) throws Exception {
		Select os = new Select(element);
		try {
		os.selectByVisibleText(ValueTobeSelected);
		}catch(Exception e){
			throw new Exception("value is not present in dropdown for webelement "+ element+" Value to be selected is "+ValueTobeSelected);
		}
	}
	
	//common method for radio button
	public void selectRadioBtnValue(List<WebElement> element,String ValueTobeSelected) {
		for (WebElement ref : element) {
			if(ref.getText().equalsIgnoreCase(ValueTobeSelected)) {
			ref.click();
			break;
		}
	}}
		//common method for checkbox
		public void selectCheckBoxValue(List<WebElement> element,String checks) {
			String[]checkarray =checks.split(",");
			for (String str : checkarray) {
			for(WebElement ele : element) {
				if(ele.getText().equalsIgnoreCase(str)){
					ele.click();
					break;
				}
			}
		}
		}

}
