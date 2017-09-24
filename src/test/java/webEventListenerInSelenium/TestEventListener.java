package webEventListenerInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestEventListener extends TestBase{
	
	@Test
	public void testEventListener(){
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).sendKeys("testCode");
	driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("testpass");
	driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
	}

}
