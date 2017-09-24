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
		Reporter.log("alert is accepted");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		Reporter.log("alert is dismissed");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
	Reporter.log("navigation to :"+url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		Reporter.log("navigated to :"+url);
		
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
		Reporter.log("finding the element :"+driver.findElement(by).getText());
		Reporter.log(by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("found the element :"+driver.findElement(by).getText());
		Reporter.log(by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("clicking on :"+element.getText());
		Reporter.log(element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		Reporter.log("clicked on :"+element.getText());
		Reporter.log(element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


}
