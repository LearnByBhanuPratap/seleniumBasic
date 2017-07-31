package scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomInZoomOutInSelenium {

	WebDriver driver;

	@Test
	public void zoomInZoomOutInSelenium() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='40%'");
		
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
		
	}
}
