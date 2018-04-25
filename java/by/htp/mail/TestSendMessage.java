package by.htp.mail;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestSendMessage {

	public String testMessage="Test message";
	public SendMessage mailRu;

	

	@Test
	public void testSendMessage() {

		mailRu = new SendMessage();
		mailRu.sendMessage();
		String actual = mailRu.getMessage().toUpperCase();
		String expected = this.testMessage;

		assertEquals(actual, expected, "Test is failed");
	}

	@Test
	public void testMessageContain() {
		mailRu = new SendMessage();
		mailRu.sendMessage();
		String actual = getInboxMessages();
		String expected = this.testMessage;
		assertEquals(actual, expected, "Test is failed");

	}

	public String getInboxMessages() {
		System.setProperty("webdriver.chrome.driver", "f:\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://mail.ru/");

		WebElement login = driver.findElement(By.xpath("//*[@id='mailbox:login']"));
		login.sendKeys("TATHTP");

		WebElement pass = driver.findElement(By.xpath("//*[@id='mailbox:password']"));
		pass.sendKeys("Klopik123");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='mailbox:submit']/input"));
		loginBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		List<WebElement> letters = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"b-letters\"]/div/div[2]/div/div[2]/div")));

		String actual=null;

		for (WebElement msg : letters) {
			if (msg.getText().toUpperCase().trim().equals(this.testMessage.toUpperCase())) {
				actual = msg.getText();

			}
			System.out.println(msg.getText());
		}

		return actual;
	}

}
