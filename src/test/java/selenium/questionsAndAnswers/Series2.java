package selenium.questionsAndAnswers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Series2 {
	/**
	 * Q:- What does mean by implicitlyWait 
	 * Q:- What does mean by expliciteWait
	 * Q:- What is polling interval 
	 * Q:- What is FluentWait 
	 * Q:- What is java script wait 
	 * Q:- What is thread.sleep 
	 * Q:- What is pageLoadTimeout 
	 * Q:- What is Java script Ready state
	 * @throws InterruptedException 
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath(""))));

		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.pollingEvery(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath(""))));

		WebElement wait3 = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(""))));
		
		wait3.click();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		
		ExpectedCondition<Boolean> javascriptWait = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	
			}
		};
		
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait4 = new WebDriverWait(driver, 60);
			wait4.until(javascriptWait);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + 60 + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
		
	}	
		
}
