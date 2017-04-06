package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TableHandeling {
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
			driver.get("file:///Users/bsingh5/git/selenium/src/test/java/selenium/table.html");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			int size = driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
			for(int i=2; i<=size;i++){
				String firstPart = "html/body/table/tbody/tr[";
				String secondPart = "]/td[2]";
				String text = driver.findElement(By.xpath(firstPart+i+secondPart)).getText();
				System.out.println(text);
						
			}
	}

	@AfterClass
	public void endTest() {
		//driver.close();
	}
}
