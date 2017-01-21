package selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDynamicObject {
	
	
	@Test
	public void testMatchingText() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://bangalore.quikr.com/");
		driver.findElement(By.xpath("//*[@id='query']")).sendKeys("fitness equipment");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'in Sport - Fitness Equipment')]")).click();
		//driver.findElement(By.xpath("//*[@id='searchbar-btn-search']")).click();
		//driver.findElement(By.xpath("//*[@id='searchFormIndex']/input[@type='button' and @value='Search']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@id='leftSideEquipment_Type']/ul/li[6]/a/input")).click();
		
		List<WebElement> data = driver.findElements(By.xpath("//*[@class='snb_ad_container']/div[1]/h3"));
		
		for(WebElement d: data){
			if(d.getText().contains("Treadmill")){
				System.out.println(d.getText());
				Assert.assertTrue(true);
			}
			else{
				System.out.println("not matching text---"+d.getText());
				Assert.assertTrue(false,"Text does not contains Treadmill");
			}
		}
		
	}

}
