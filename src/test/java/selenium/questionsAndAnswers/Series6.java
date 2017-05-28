package selenium.questionsAndAnswers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Series6 {

	/**
	 How to work with alert
	 How to work with iframe
	 How to work with select
	 How to execute java script
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		
		driver.findElements(By.tagName("iframe")).size();
		
		driver.switchTo().frame(0);
		
		driver.switchTo().frame("auto");
		
		driver.switchTo().frame(driver.findElement(By.className("")));
		
		Select select = new  Select(driver.findElement(By.xpath("")));
		select.selectByIndex(1);
		select.selectByValue("valuseName");
		select.selectByVisibleText("textName");
		
		select.deselectAll();
		select.deselectByIndex(3);
		select.deselectByValue("valuseName");
		select.deselectByVisibleText("textName");
		
		WebDriver dr = new FirefoxDriver();
		
		EventFiringWebDriver driver1 = new EventFiringWebDriver(dr);
		
		driver1.executeScript("document.getElementById(\"idName\")");
				
		driver1.executeScript("document.getElementById(\"inputSuccess\").value=\"test\"");
		
		//JavascriptExecutor javascript = ((JavascriptExecutor)driver).executeScript(arg0, arg1)
		
	}
}
