package selenium.questionsAndAnswers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Series4 {

	/**
	 How to get window id on run time
	 How to handle multiple window
	 How to maximize window
	 How to get co-ordinate of window 
	 */
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		Set<String> windowsId = driver.getWindowHandles();
		Iterator<String> itr = windowsId.iterator();
		ArrayList<String> ids = new ArrayList<String>();
		while(itr.hasNext()){
			ids.add(itr.next());
		}
		
		driver.switchTo().window(ids.get(3));
		driver.findElement(By.xpath("")).isDisplayed();
		driver.close();
		
		driver.switchTo().window(ids.get(2));
		
		driver.close();
		
		driver.switchTo().window(ids.get(0));
		
		driver.manage().window().maximize();
		
		Point position = driver.manage().window().getPosition();
		position.getX();
		position.getY();
		
		Point location = driver.findElement(By.xpath("")).getLocation();
		location.getX();
		location.getY();
	}
}
