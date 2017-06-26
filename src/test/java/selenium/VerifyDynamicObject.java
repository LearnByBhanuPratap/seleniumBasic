package selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDynamicObject {
	public WebDriver driver;

	@Test
	public void testMatchingText() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")
		// + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://bangalore.quikr.com/");
		driver.findElement(By.xpath("//*[@id='query']")).sendKeys("fitness equipment");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[contains(text(),'in Sport - Fitness Equipment')]")).click();
		driver.findElement(By.xpath(".//*[@id='submitSearch']")).click();
		// driver.findElement(By.xpath("//*[@id='searchFormIndex']/input[@type='button'
		// and @value='Search']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='Equipment_Type']/div[2]/ul/li[1]/a")).click();
		Thread.sleep(5000);
		List<WebElement> data = driver.findElements(By.xpath(".//*[@id='resultCont']/section/div/div/span/a"));

		for (WebElement d : data) {
			if (d.getText().contains("ab") || d.getText().contains("Ab")) {
				System.out.println(d.getText());
				Assert.assertTrue(true);
			} else {
				System.out.println("not matching text---" + d.getText());
				Assert.assertTrue(false, "Text does not contains Treadmill");
			}
		}

	}

}
