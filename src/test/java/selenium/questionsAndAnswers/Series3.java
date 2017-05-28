package selenium.questionsAndAnswers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Series3 {

	/**
	 How to enter data in text box
	 How to click on link
	 How to check element is displayed or not
	 How to check checkbox is selected or not
	 What is method to find element on UI
	 What is method to find all elements on UI
	 How to get URL of current window
	 How to get title of page
	 */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.findElement(By.cssSelector("")).sendKeys("");
		
		driver.findElement(By.cssSelector("")).click();
		
//		try {
//			driver.findElement(By.xpath("")).isDisplayed();
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
		driver.findElement(By.id("")).isSelected();
		
		driver.findElement(By.id("")).getAttribute("class").contains("checked");
		
		driver.findElements(By.tagName("//a")).size();
		
		driver.getCurrentUrl();
		
		driver.getTitle();
	}

}
