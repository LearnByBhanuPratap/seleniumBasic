package webEventListenerInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

/**
 * 
 * @author Bhanu Pratap
 *
 */
public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		
		Reporter.log("alert is preseent"+ driver.switchTo().alert().getText());
	}

	public void afterAlertAccept(WebDriver driver) {
		Reporter.log("Alert is accepted");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		Reporter.log("Alert is dismissed");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
	Reporter.log("Navigation to :"+url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		Reporter.log("Navigated to :"+url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("Finding the element :");
		Reporter.log(by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("Found the element :");
		Reporter.log(by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("Clicking on :"+element.getText());
		Reporter.log(element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		Reporter.log("Clicked on :"+element);
		Reporter.log(element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("Value of the:" + element.toString()
		+ " before any changes made");
		
		Reporter.log("Value of the:" + element.toString()
		+ keysToSend.toString());
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("Element value changed to: " + element.toString());
		Reporter.log("Value of the:" + element.toString()
		+ keysToSend.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured: " + throwable);
		
	}


}
