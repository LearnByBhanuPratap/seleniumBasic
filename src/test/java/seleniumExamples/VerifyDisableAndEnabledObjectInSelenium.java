package seleniumExamples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDisableAndEnabledObjectInSelenium {
	WebDriver driver;

	@Test
	public void verifyDisableAndEnabledObjectInSelenium() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.olx.in/bangalore/cars/q-swift/");
		
		String className = driver.findElement(By.xpath(".//*[@id='param_model']")).getAttribute("class");
		Assert.assertEquals(className, "param paramSelect disabled");
		
		// Click on Brand Name
		driver.findElement(By.xpath(".//*[@id='param_subcat']/div[2]/a/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='param_subcat']/div[2]/ul/li[2]/a")).click();
		
		String className1 = driver.findElement(By.xpath(".//*[@id='param_model']")).getAttribute("class");
		Assert.assertNotEquals(className1, "param paramSelect disabled");

	}
}
