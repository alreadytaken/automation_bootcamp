package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.globant.automation.util.SeleniumUtils;

public class LinkedInMessageResPage extends BasePage {

	public LinkedInMessageResPage(WebDriver driver) {
		super(driver);
	}
    public LinkedInMessageResPage originalMessage() {
        WebElement originalMessage = SeleniumUtils.getWebElement(driver,
                By.xpath("//span[@class=\"msg-conversation-card__message-snippet-body display-flex\"]"));
        if (SeleniumUtils.waitForElementToBeVisible(originalMessage, driver)) {
            originalMessage.getText();       
        }
        return new LinkedInMessageResPage(driver);
    }
    public LinkedInMessageResPage resultMessage() {
        WebElement resultMessage = SeleniumUtils.getWebElement(driver,
                By.xpath("//div[@class=\"msg-conversation-card__row pr2\"][2]"));
        if (SeleniumUtils.waitForElementToBeVisible(resultMessage, driver)) {
            resultMessage.getText();
        }
        return new LinkedInMessageResPage(driver);
    }
}
