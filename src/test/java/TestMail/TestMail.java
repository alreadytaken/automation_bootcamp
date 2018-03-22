package TestMail;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.annotations.Test;

import TestPedidosYa.PedidosYaTest;

public class TestMail extends FunctionalTest {
	
private static final Logger LOG;
    

    static {
        LOG = LogManager.getLogger(PedidosYaTest.class);
    }
	
	
	@Test
	public void TestPedidosYa() throws  ElementNotVisibleException{
		LOG.info("Search test");
		driver.get("https://gmail.com");
		GmailLoginPage page1 = new GmailLoginPage(driver);
		MailInboxPage page2 = new MailInboxPage(driver);
		String mail = "kakarottoui7@gmail.com";
		String password = "Universe7";
		page1.entermail(mail);
		page1.enterpassword(password);
		page1.enter();
		List<String> subject = new ArrayList<>();
		for (int i = 0; i < page2.mailsubjects().size(); i=i+2) {
			subject.add(page2.mailsubjects().get(i).getText());
			
		}
		
		System.out.println(subject);
		
		
	}
	
	

}
