package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SeleniumWithJavaScriptExecuator {
	
	  WebDriver driver;
		
		@BeforeClass
		public void setUp() {
			System.out.println(System.getProperty("user.dir"));
			if(System.getProperty("os.name").contains("Mac OS")){
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");	
			}
			else if(System.getProperty("os.name").contains("window")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");	
			}
			
			driver = new FirefoxDriver();
			driver.get("file:///Users/bsingh5/Downloads/startbootstrap-sb-admin-2-gh-pages%203/pages/forms.html");

		}
		
		@Test
		public void javaScriptExecuator() throws InterruptedException{
	     JavascriptExecutor exe = (JavascriptExecutor)driver;
	     exe.executeScript("arguments[0].value=\"testselenium\"", driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div[2]/div/div[1]/form/div[1]/input")));
	     //exe.executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div[2]/div/div[1]/form/div[4]/input")));
	     exe.executeScript("document.getElementById(\"inputSuccess\").value=\"test\"");
	     exe.executeScript("document.getElementById(\"inputWarning\").value=\"testtest\"");
	     
	     //document.getElementsByClassName("dataTables_filter").click();
	     
	     driver.get("file:///Users/bsingh5/Downloads/startbootstrap-sb-admin-2-gh-pages%203/pages/tables.html");
	     Thread.sleep(5000);
	     //exe.executeScript("document.getElementsByName(\"dataTables-example_length\")[0].click();");
	     //exe.executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='dataTables-example_length']/label/select")));
	     exe.executeScript("document.getElementsByName(\"dataTables-example_length\")[0].value=50");
		}

}
