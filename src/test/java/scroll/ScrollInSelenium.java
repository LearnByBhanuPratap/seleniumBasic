package scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollInSelenium {


	WebDriver driver;

	@Test
	public void scrollInSelenium() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		// it will go till the end vertically
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(3000);
		// it will come up vertically
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		
		// it will go till the pixel specified
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		
		// it will come back till the pixel specified
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1500)");
		
		Thread.sleep(3000);
		
		// it will go down till the object specified.
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[2]/h5/a")));
	    
	}
}
