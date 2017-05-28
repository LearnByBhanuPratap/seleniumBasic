package selenium.questionsAndAnswers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Series5 {
	/**
	 How to do mouse over
	 How to do drag drop
	 How to do double click
	 How Keys class works
	 */
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(""))).build().perform();
		
		Actions action1 = new Actions(driver);
		WebElement source = driver.findElement(By.xpath(""));
		WebElement target = driver.findElement(By.xpath(""));
		action1.dragAndDrop(source, target);
		
		action1.clickAndHold(driver.findElement(By.xpath("")))
		.moveToElement(driver.findElement(By.xpath(""))).release(driver.findElement(By.xpath("")));
		
		action1.build().perform();
		
		Actions action2 = new Actions(driver);
		
		action2.moveToElement(driver.findElement(By.xpath(".//*[@id='draggable']")));
		action2.keyDown(Keys.CONTROL);
		action2.moveToElement(driver.findElement(By.xpath(".//*[@id='droppable']")));
		action2.keyUp(Keys.CONTROL);
		action2.build().perform();
		
		action2.moveToElement(driver.findElement(By.xpath(""))).doubleClick();
		
		action2.sendKeys(Keys.ENTER);
		
		action2.sendKeys(Keys.F6);
		
	}
}
