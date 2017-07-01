package seleniumExamples;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterProduct {
	WebDriver driver;

	@Test
	public void filterProduct() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.olx.in/bangalore/");
		driver.findElement(By.xpath(".//*[@id='cityField']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='regions-layer']/div[2]/div/ul[1]/li[2]/a/span")).click();
		// Click on Browse Categories
		driver.findElement(By.xpath(".//*[@id='main-category-choose-label']")).click();
		Thread.sleep(3000);
		// Click on Cars
		driver.findElement(By.xpath("//a[@data-name='Cars']")).click();
		
		//Enter swift
		driver.findElement(By.xpath(".//*[@id='search-text']")).sendKeys("swift");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='autosuggest-div']/ul/li[1]/a/span[1]")).click();
		
		List<WebElement> alldata = driver.findElements(By.xpath("//*[@id='offers_table']/tbody/tr/td/table/tbody/tr/td[2]/h3/a/span"));
		Iterator<WebElement> itr = alldata.iterator();
		while(itr.hasNext()){
			String data = itr.next().getText();
			System.out.println(data);
			if(data.toLowerCase().contains("swift")){
			}
			else{
				Assert.assertTrue(false, data);
			}
		}
		
		alldata = driver.findElements(By.xpath(".//*[@id='promotedAd']/tbody/tr/td/table/tbody/tr/td[2]/h3/a/span"));
		itr = alldata.iterator();
		while(itr.hasNext()){
			String data = itr.next().getText();
			System.out.println(data);
			if(data.toLowerCase().contains("swift")){
			}
			else{
				Assert.assertTrue(false, data);
			}
		}
		
	}

}
