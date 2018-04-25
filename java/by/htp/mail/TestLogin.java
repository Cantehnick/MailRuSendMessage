package by.htp.mail;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestLogin {

	private String testInboxFolderTitle;
	Login mailRu;
	
	@Test
	public void testloginMailRu(String inboxFolderTitle) {
		String actual = this.testInboxFolderTitle.toUpperCase();
		String expected=mailRu.getInboxFolderTitle().toUpperCase();
		assertEquals(actual, expected,"Test is failed");
	}
	
	@BeforeTest
	  public void beforeTest() {
		  mailRu = new Login();
		  mailRu.mailRuLogin();
		  this.testInboxFolderTitle = "Входящие";
		
	  }













}
