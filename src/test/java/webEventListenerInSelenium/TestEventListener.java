package webEventListenerInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestEventListener extends TestBase{
	
	@Test
	public void testEventListener() throws InterruptedException{
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"))));
	driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	

	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("testCode");
	driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("testpass");
	driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	}

}
