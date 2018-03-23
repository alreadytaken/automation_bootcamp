package Mail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class MailHome {

	private WebDriver driver;

	public MailHome(WebDriver driver) {

		this.driver = driver;

		if (!SeleniumUtils.isPresent(By.xpath("//span[@class=\"bog\"]"), driver)) {
			throw new IllegalStateException("Page did not load");
		}

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"bog\"]")
	List<WebElement> subject;

	public List<String> getToString() {

		List<String> listString = new ArrayList<>();

		for (int i = 0; i < subject.size(); i = i + 2) {
			listString.add(subject.get(i).getText());
		}
		return listString;
	}

	public List<String> getSubject() {
		List<String> listString;
		listString = getToString();
		return listString;
	}

	public List<String> returnSubject(List<String> emails) {
		return emails;
	}

}
