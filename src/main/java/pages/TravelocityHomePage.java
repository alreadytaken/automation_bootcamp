package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.util.SeleniumUtils;

public class TravelocityHomePage extends BasePage{

	public TravelocityHomePage(WebDriver driver) {
		super(driver);

	}
	@FindBy (xpath = "//button[@id='tab-flight-tab-hp']")
	private WebElement flightsButton;

	public TravelocityFlightPage clickOnFlightsButton() {
		 if (SeleniumUtils.waitForElementToBeVisible(flightsButton, driver)) {
        flightsButton.click();
		 }
        return new TravelocityFlightPage(driver);

	}
}
