package selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframeTest {

	//https://github.com/mozilla/geckodriver/releases (0.15)
	
	//https://sites.google.com/a/chromium.org/chromedriver/downloads (2.28)
	
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
	public void verifyNumberOfNavigationMenus() {
			driver.get("file:///Users/bsingh5/Desktop/SeleniumPractices/iframe1.html");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.switchTo().frame("test");
			//driver.switchTo().frame(3);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='test']")));
			driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}
}


