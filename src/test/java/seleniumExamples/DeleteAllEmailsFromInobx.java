package seleniumExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteAllEmailsFromInobx {
	WebDriver driver;
	@Test
	public void deleteAllEmailsFromInobx() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.sharklasers.com/inbox");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//span[@id='inbox-id']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='inbox-id']/input")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='inbox-id']/button[1]")).click();
		Thread.sleep(10000);
		int size = driver.findElements(By.xpath("//form[@class='email_list_form']/table/tbody/tr/td[1]/input")).size();
		for(int i =1; i<=size; i++){
			String firstPart = "//form[@class='email_list_form']/table/tbody/tr[";
			String secondPart = "]/td[1]/input";
			System.out.println(firstPart+i+secondPart);
			driver.findElement(By.xpath(firstPart+i+secondPart)).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='del_button']")).click();
	}
}
