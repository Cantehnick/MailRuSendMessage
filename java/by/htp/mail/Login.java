package by.htp.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	private String inboxFolderTitle;

	public String getInboxFolderTitle() {
		return inboxFolderTitle;
	}

	public void setInboxFolderTitle(String inboxFolderTitle) {
		this.inboxFolderTitle = inboxFolderTitle;
	}

	public void mailRuLogin() {
		System.setProperty("webdriver.chrome.driver", "f:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://mail.ru/");

		WebElement login = driver.findElement(By.id("mailbox:login"));
		login.sendKeys("TATHTP");

		WebElement pass = driver.findElement(By.id("mailbox:password"));
		pass.sendKeys("Klopik123");
		pass.submit();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement inbox = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b-nav_folders\"]/div/div[1]")));
		if (inbox.isEnabled()) {
			setInboxFolderTitle(inbox.getText()); 
		}

		WebElement logoutLink = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"PH_logoutLink\"]")));

	}

}
