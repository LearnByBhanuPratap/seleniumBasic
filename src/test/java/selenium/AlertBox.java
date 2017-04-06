package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertBox {
	  WebDriver driver;
		
			@BeforeClass
			public void setUp() {
				//for Mac OS
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");
				// For Window OS
				//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				

			}

			@Test
			public void verifyNumberOfNavigationMenus() throws InterruptedException {
					driver.get("file:///Users/bsingh5/Desktop/SeleniumPractices/alert.html");
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					driver.findElement(By.xpath("html/body/button")).click();
					
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
			}

			@AfterClass
			public void endTest() {
				driver.close();
			}
}
