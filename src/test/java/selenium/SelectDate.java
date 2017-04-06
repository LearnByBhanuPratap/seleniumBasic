package selenium;

import org.testng.annotations.Test;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDate {
	@Test
	public void seleteDate() throws InterruptedException{
		String selectdata = "10/15/2016";
		Date d = new Date(selectdata);
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
        String date = dt.format(d);
        System.out.println(date);
        String[] split = date.split("/");
        System.out.println(split[0]+" "+split[1]+" "+split[2]);
        String month = split[0]+" "+split[2];
        System.out.println("month-------"+month);
    	WebDriver driver = new FirefoxDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//*[@id='gi_oneway_label']")).click();
		driver.findElement(By.xpath("//*[@id='start-date']")).click();
		Thread.sleep(2000);
		//*[contains(text(),'November 2016')]
		while(true){
			try{
				driver.findElement(By.xpath("//*[contains(text(),'"+month+"')]")).isDisplayed();				
				//*[@id='jrdp_start-calen_8_8_2016']/div
				String firstPart = "//*[@id='jrdp_start-calen_";
				String secondPart = "']/div";
				String[] splitDate = selectdata.split("/");
				String finalPart = firstPart+splitDate[0]+"_"+splitDate[1]+"_"+splitDate[2]+secondPart;
				System.out.println("selecting this date in calender:-"+finalPart);
				driver.findElement(By.xpath(finalPart)).click();
				break;
			}
			catch(Exception e){
				driver.findElement(By.xpath("//*[@id='jrdp_start-calen_nextmonth_multi_1']")).click();
				Thread.sleep(2000);
			}
		}
	}

}
