package seleniumExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteEmailBasedOnSubjectLine {

	WebDriver driver;

	@Test
	public void deleteEmailBasedOnSubjectLine() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.sharklasers.com/inbox");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//span[@id='inbox-id']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//span[@id='inbox-id']/input")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='inbox-id']/button[1]")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[contains(text(),'swetlib86@gmail.com ')]/preceding-sibling::td/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='del_button']")).click();
	}
}
