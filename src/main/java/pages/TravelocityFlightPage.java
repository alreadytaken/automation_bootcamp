package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.util.SeleniumUtils;

public class TravelocityFlightPage extends BasePage{

	public TravelocityFlightPage (WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//input[@id=\'flight-origin-hp-flight\']")
	private WebElement flyingFrom;
	
	@FindBy (xpath = "//ul[@id=\'typeaheadDataPlain\']")
	private WebElement autocomplete;
	
	@FindBy (xpath = "//input[@id='flight-destination-hp-flight']")
	private WebElement flyingTo;
	
	@FindBy (xpath = "//*[@id=\'aria-option-0\']/span[2]/div")
	private WebElement autocomplete2;
	
	@FindBy (xpath = "//input[@id='flight-departing-hp-flight']")
	private WebElement departing;
	
	@FindBy (xpath = "//*[@id=\'flight-departing-wrapper-hp-flight\']/div/div/div[2]/table/tbody/tr[3]/td[3]/button")
	private WebElement departingDay;
	
	@FindBy (xpath = "//*[@id='gcw-flights-form-hp-flight']/div[9]/label/button")
	private WebElement searchButton;
	

	public TravelocityFlightPage flightOrigin(String str) {
        if (SeleniumUtils.waitForElementToBeVisible(flyingFrom, driver)) {
		flyingFrom.sendKeys( str);
        }
		return new TravelocityFlightPage(driver);
	}
	
	public TravelocityFlightPage autocompleteFrom() {
		 if (SeleniumUtils.waitForElementToBeVisible(autocomplete, driver)) {
		autocomplete.click();
		 }
		return new TravelocityFlightPage(driver);
	}
	
	public TravelocityFlightPage flightDestination(String str) {
		 if (SeleniumUtils.waitForElementToBeVisible(flyingTo, driver)) {
		flyingTo.sendKeys( str);
		 }
		return new TravelocityFlightPage(driver);
	}
	
	public TravelocityFlightPage autocompleteTo() {
		 if (SeleniumUtils.waitForElementToBeVisible(autocomplete2, driver)) {
		autocomplete2.click();
		 }
		return new TravelocityFlightPage(driver);
	}
	
	public TravelocityFlightPage flightDeparting() {
		 if (SeleniumUtils.waitForElementToBeVisible(departing, driver)) {
		departing.click();
		 }
		return new TravelocityFlightPage(driver);
	}
	
	public TravelocityFlightPage flightDepartingDay() {
		 if (SeleniumUtils.waitForElementToBeVisible(departingDay, driver)) {
		departingDay.click();
		 }
		return new TravelocityFlightPage(driver);
	}
	
	public TravelocityFlightPage clickOnsearchButton() {
		 if (SeleniumUtils.waitForElementToBeVisible(searchButton, driver)) {
		searchButton.click();
		 }
		return new TravelocityFlightPage(driver);
	}

	

}
