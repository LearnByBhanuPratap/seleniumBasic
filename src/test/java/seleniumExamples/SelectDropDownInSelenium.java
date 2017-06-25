package seleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDownInSelenium {

	WebDriver driver;

	@Test
	public void verifyLowestFirstPriceListInProduct_deatilsPage() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		Select select = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
		
		select.selectByIndex(3);
		
		select = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
		
		select.selectByVisibleText("Jan");
		
		select = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
		
		select.selectByValue("2014");
		
		
	
	}
}
