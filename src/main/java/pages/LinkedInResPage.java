package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.util.SeleniumUtils;

public class LinkedInResPage extends BasePage {

	public LinkedInResPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = (("//li[@id=\'messaging-nav-item']//span[@class='nav-item__title']")))
	private WebElement messege;

	public LinkedInMessege messegeButton() {
		if (SeleniumUtils.waitForElementToBeVisible(messege, driver)) {
		messege.click();
		}
		return new LinkedInMessege(driver);

	}
    public LinkedInMessege popUp() {
        WebElement popUp = SeleniumUtils.getWebElement(driver,By.xpath("//button[@class=\"msg-modal-presence-onboarding__primary button-primary-medium\"]"));
        if (SeleniumUtils.waitForElementToBeVisible(popUp, driver)) {
            popUp.click();
        }
        return new LinkedInMessege(driver);
    }
}
