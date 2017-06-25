package seleniumExamples;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToSelectWindowInSelenium {
	

	WebDriver driver;

	@Test
	public void howToSelectWindowInSelenium() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("http://www.hdfcbank.com/htdocs/common/onlineservices/netbankingloginsafe_nri.htm");
	    driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[1]/ul/li[1]/a")).click();
	    
	    Set<String> windows = driver.getWindowHandles();
	    Iterator<String> itr = windows.iterator();
	    String parentWindow = itr.next();
	    String childWindow = itr.next();
	    
	    driver.switchTo().window(childWindow);
	    driver.findElement(By.xpath(".//*[@id='netbanking']")).click();
	    Thread.sleep(5000);
	    driver.close();
	    driver.switchTo().window(parentWindow);
	    driver.findElement(By.xpath(".//*[@id='element1']/div[4]/a/img")).isDisplayed();
	}

}
