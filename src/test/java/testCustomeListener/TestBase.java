package testCustomeListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public static WebDriver driver;

	
    @BeforeTest
	public void setUp(){
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
    //	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
    	// For Window OS
    	// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
    driver = new ChromeDriver();

    	}

}
