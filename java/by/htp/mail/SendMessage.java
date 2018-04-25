package by.htp.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class SendMessage {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sendMessage() {

		System.setProperty("webdriver.chrome.driver", "f:\\driver\\chromedriver.exe");

		Login login = new Login();

		login.mailRuLogin();
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement writeLetter=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#b-toolbar__left > div > div > div.b-toolbar__group.b-toolbar__group_left > div > a > span")));
		writeLetter.click();

		WebElement inputAdress = driver.findElement(By.xpath("//*[@class='label-input']/div"));
		inputAdress.click();
		inputAdress.sendKeys(" TATHTP@mail.ru");

		WebElement inputTheme = driver.findElement(By.xpath("//*[@class='b-input']"));
		inputTheme.sendKeys("Test");

		driver.switchTo()
				.frame(driver.findElement(By.xpath("//*[@class='mceIframeContainer mceFirst mceLast']/iframe")));
		WebElement inputMessage = driver.findElement(By.xpath("//*[@id=\'tinymce\']"));
		setMessage("Test message");
		inputMessage.sendKeys(getMessage());
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div/span")).click();

		WebElement inboxFolder = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b-nav_folders\"]/div/div[1]")));
		inboxFolder.click();

	}

}
