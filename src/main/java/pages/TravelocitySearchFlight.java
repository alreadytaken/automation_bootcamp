package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.util.SeleniumUtils;


public class TravelocitySearchFlight extends BasePage{

	public TravelocitySearchFlight(WebDriver driver) {
		super(driver);	
	}

	public void getPrices() {
		List <WebElement> priceFlights = driver.findElements(By.xpath("//div[@class='primary-content   custom-primary-padding'][" + 1 +"]"));

		for (int i=0; i<priceFlights.size(); i++) {
			System.out.println(priceFlights.get(i).getText());

		}
	}

	public boolean OrderByPrice() {

		ArrayList<Double> prices = new ArrayList<Double>();
		String element = "//span[(span[@class='full-bold no-wrap'])[";
		int i = 1;

		while(SeleniumUtils.waitForElementToBeVisible(driver, By.xpath(element+i+"]"), 10)){
			String priceStr = driver.findElement(By.xpath(element+i+"]")).getText().replace("$","");
			prices.add(Double.parseDouble(priceStr));
			i++;
		}
		boolean isShorted = true;
		return isShorted;
	}



}
