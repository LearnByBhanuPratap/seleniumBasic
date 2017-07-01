package seleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDisableObjectInSelenium {

	WebDriver driver;

	@Test
	public void verifyDisableObjectInSelenium() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.olx.in/bangalore/cars/q-swift/");
		
		String className = driver.findElement(By.xpath(".//*[@id='param_model']")).getAttribute("class");
		Assert.assertEquals(className, "param paramSelect disabled");

	}
}
