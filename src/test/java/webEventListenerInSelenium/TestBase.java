package webEventListenerInSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public WebDriver dr;
	public EventFiringWebDriver driver;
	public WebEventListener eventListener;
	
    @BeforeTest
	public void setUp(){
    //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
    	// For Window OS
    	// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
    //	dr = new ChromeDriver();
    	dr = new FirefoxDriver();
    	driver = new EventFiringWebDriver(dr);
    	eventListener = new WebEventListener();  
    	driver.register(eventListener);
    	}

}
