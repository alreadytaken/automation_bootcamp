package test.compare.results;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingResultsPage {

	@FindBy(how = How.XPATH, using ="//h2/a")
	private List<WebElement> bingResults;
	
	private WebDriver driver;

	public BingResultsPage(WebDriver driver){
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	public List<String> ListFirstFive(){
		/*
		NO GUARDA CINCO ELEMENTOS
		List<WebElement> aux = bingResults.subList(0, 5);
		List<String> res = new ArrayList();
		for(WebElement e: aux) {
			res.add(e.getText());
		}
		return res;
		*/
		List<String> res = new ArrayList();
		for(int i=0; i<=4; i++) {
			res.add(bingResults.get(i).getText());
		}
		return res;
	}

}

