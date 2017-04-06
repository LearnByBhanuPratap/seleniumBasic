package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragDropTest {
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
			
				driver.get("http://jqueryui.com/droppable/");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
				
				WebElement source = driver.findElement(By.xpath(".//*[@id='draggable']"));
				
				WebElement destination = driver.findElement(By.xpath(".//*[@id='droppable']"));
				
				Thread.sleep(2000);
				
				Actions action = new Actions(driver);
			
				action.dragAndDrop(source, destination).perform();
		}

		@AfterClass
		public void endTest() {
			//driver.close();
		}

}
