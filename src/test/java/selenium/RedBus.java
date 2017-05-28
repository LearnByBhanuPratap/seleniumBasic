package selenium;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RedBus{
	WebDriver driver;
	
	List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec");
	String expDate = null;
	int expMonth;
	int expYear;
	
	String calDate = null;
	int calMonth;
	int calYear;
	
	boolean dateNotFound;
	
	@BeforeTest
	public void loadRedBus(){
		//for Mac OS
		System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");
		// For Window OS
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver();

		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("dom.webnotifications.enabled", false);
		//driver = new FirefoxDriver(profile);
	
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
	}
	
	@Test(priority=1)
	public void searchBus(){
		WebElement srcElement = driver.findElement(By.id("src"));
		srcElement.clear();
		srcElement.sendKeys("Pune");
		driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li[1]")).click();
		
		
		WebElement dstElement = driver.findElement(By.id("dest"));
		dstElement.clear();
		dstElement.sendKeys("Bangalore");
		driver.findElement(By.xpath(".//*[@id='search']/div/div[2]/div/ul/li[1]")).click();
	}
	
	@Test(priority=2)
	public void selectDateCal(){
		WebElement calendar = driver.findElement(By.xpath(".//input[@id='onward_cal']"));
		calendar.click();
		
		expDate = "20";
		expMonth = 5;
		expYear=2017;
		dateNotFound = true;
		
		/*WebElement monthYearEle = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//table//td[@class='monthTitle']"));
		String monthYear= monthYearEle.getAttribute("innerHTML");
		
		String[] s = monthYear.split(" ");
		String calMonth = s[0];
		int calYear = Integer.parseInt(s[1]);*/
		
		while(dateNotFound){
			WebElement monthYearEle = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//table//td[@class='monthTitle']"));
			String monthYear= monthYearEle.getAttribute("innerHTML");
			
			String[] s = monthYear.split(" ");
			String calMonth = s[0];
			int calYear = Integer.parseInt(s[1]);
			
			
			////If current selected month and year are same as expected month and year then go Inside this condition.
			if(monthList.indexOf(calMonth)+1 ==expMonth && expYear==calYear){
				selectDate(expDate);
				dateNotFound = false;
			}
			
			//If current selected month and year are less than expected month and year then go Inside this condition
			else if(monthList.indexOf(calMonth)+1 <expMonth && expYear==calYear||expYear>calYear){
				//Click on next button of date picker.
				calendar.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//button[.='>']")).click();
			}
			//If current selected month and year are greater than expected month and year then go Inside this condition.
			else if(monthList.indexOf(calMonth)+1 >expMonth && expYear==calYear||expYear<calYear){
				calendar.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//button[.='<']")).click();
			}
		}
		
		//driver.findElement(By.xpath(".//*[@id='search_btn']")).click();
		
	}
	
	public void selectDate(String date){
		WebElement datePicker = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']"));
		List<WebElement> dates = datePicker.findElements(By.tagName("td"));
		for(WebElement temp:dates){
			if(temp.getText().equals(date)){
				temp.click();
				break;
			}
		}
	}
	
	@AfterTest
	public void closeBroser(){
		driver.close();
	}

}


