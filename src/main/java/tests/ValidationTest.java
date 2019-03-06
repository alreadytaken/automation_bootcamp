package tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.automation.util.SeleniumUtils;

import pages.LinkedInHomePage;
import pages.LinkedInMessageResPage;
import pages.LinkedInMessege;
import pages.LinkedInResPage;

public class ValidationTest extends BaseTest{

	@Test
	public void test1() {
		LinkedInHomePage home = new LinkedInHomePage(driver);
		LinkedInHomePage email = home.insertEmail("jime123cedres@gmail.com");
		LinkedInHomePage password = home.insertPassword("Tests.123");
		LinkedInResPage submitBotton = home.submit();	
		Assert.assertTrue(true, "Its logs correctly");
	}
	@Test
	public void test2(){
		LinkedInHomePage home = new LinkedInHomePage(driver);
		LinkedInHomePage email = home.insertEmail("jime123cedres@gmail.com");
		LinkedInHomePage password = home.insertPassword("Tests.124");
		LinkedInResPage submitBotton = home.submit();
		Assert.assertEquals(driver.findElement(By.xpath("//form[@class='login_form']")).getText(),"The login was incorrect");

	}
	@Test 
	public void test3()  {
		LinkedInHomePage home = new LinkedInHomePage(driver);
		LinkedInHomePage email = home.insertEmail("jime123cedres@gmail.com");
		LinkedInHomePage password = home.insertPassword("Tests.123");
		LinkedInResPage submitBotton = home.submit();
		LinkedInResPage res = new LinkedInResPage(driver);
		res.messegeButton();
		LinkedInMessege mes = new LinkedInMessege(driver);
		mes.newMes();
		LinkedInMessege writeEmail = mes.EmailOrUser("bootcamp destino");
		LinkedInMessege writeMessege = mes.writeMessege("Automation-bootcamp-");
		mes.ClickUser();
		LinkedInMessege sendMessege = mes.sendMessegeButton();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		mes.clickMe();
		mes.clickSignOut();
		LinkedInHomePage home2 = new LinkedInHomePage(driver);
		LinkedInHomePage email2 = home.insertEmail("bootcamp.destino@gmail.com");
		LinkedInHomePage password2 = home.insertPassword("Test.123");
		LinkedInResPage submitBotton2 = home.submit();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		LinkedInResPage res2 = new LinkedInResPage(driver);
		res2.messegeButton();
		LinkedInMessege mes2 = new LinkedInMessege(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        LinkedInMessageResPage finish = new LinkedInMessageResPage(driver);
        finish.originalMessage();
        finish.resultMessage();
        Assert.assertEquals(finish, finish, "the test must be correct");
        
        
	}
}

