package seleniumExamples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowToVerifyCommonTextInSelenium {

	WebDriver driver;

	@Test
	public void howToVerifyCommonTextInSelenium() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		ArrayList<String> Expectedarray = new ArrayList<String>();
		Expectedarray.add("Features & Benefits");
		Expectedarray.add("Mobile Phone Bills");
		Expectedarray.add("Electricity and Telephone Bills");
		Expectedarray.add("Insurance Premium");
		Expectedarray.add("How to register for BillPay");
		Expectedarray.add("FAQs");
		driver.get("http://www.hdfcbank.com/htdocs/nri_banking/payments/BillPay/BillPay.htm");
	    List<WebElement> totaltext = driver.findElements(By.xpath("//div[@id='nre_savings_acc']/ul/li"));
	    Iterator<WebElement> itr = totaltext.iterator();
	    ArrayList<String> Actaularray = new ArrayList<String>();
	    while(itr.hasNext()){
	    	Actaularray.add(itr.next().getText());
	    }
	    System.out.println(Actaularray);
	    System.out.println(Expectedarray);
	    Assert.assertEquals(Actaularray, Expectedarray);
	    
	}
}
