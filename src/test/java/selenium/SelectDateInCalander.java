package selenium;

import org.testng.annotations.Test;
import java.sql.Driver;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SelectDateInCalander {
	
	
	@Test
	public void selectDateInCalender() throws ParseException, InterruptedException{
		
		@SuppressWarnings("unused")
		Format formatter = new SimpleDateFormat("MMMM"); 
		String selectdata = "10/15/2016";
		@SuppressWarnings("deprecation")
		Date d = new Date(selectdata);
		
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
        String date = dt.format(d);
        System.out.println(date);
        
        String[] split = date.split("/");
        String month = split[0]+" "+split[2];
         System.out.println(month);
      //td[contains(text(),'September 2016')]
        
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//*[@id='gi_oneway_label']")).click();
		driver.findElement(By.xpath("//*[@id='start-date']")).click();
		
		Thread.sleep(2000);
		while(true){
			try{
				driver.findElement(By.xpath("//td[contains(text(),'"+month+"')]")).isDisplayed();
				String firstPart = "//*[@id='jrdp_start-calen_";
				String secondPart = "']/div";
				String[] splitDate = selectdata.split("/");
				String finalPart = firstPart+splitDate[0]+"_"+splitDate[1]+"_"+splitDate[2]+secondPart;
				System.out.println(finalPart);
				//*[@id='jrdp_start-calen_8_8_2016']/div
				driver.findElement(By.xpath(finalPart)).click();
				break;
			}
			catch(Exception e){
				driver.findElement(By.xpath("//*[@id='jrdp_start-calen_nextmonth_multi_1']")).click();
				Thread.sleep(1000);
			}
		}
	}

}
