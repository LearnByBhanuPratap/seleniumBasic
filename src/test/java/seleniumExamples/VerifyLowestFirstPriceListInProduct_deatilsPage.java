package seleniumExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLowestFirstPriceListInProduct_deatilsPage {

	WebDriver driver;

	@Test
	public void verifyLowestFirstPriceListInProduct_deatilsPage() throws InterruptedException {
		// for Mac OS
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Printed Chiffon Dress')]"))));
		
		Select select = new Select(driver.findElement(By.xpath(".//*[@id='selectProductSort']")));
		select.selectByVisibleText("Price: Lowest first");
		
		Thread.sleep(8000);
		List<WebElement> price = driver.findElements(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/div/span[1]"));
		
		ArrayList<Integer> array = new ArrayList<Integer>();

		Iterator<WebElement> itr = price.iterator();

		while (itr.hasNext()) {
			String p = itr.next().getText();
			System.out.println(p);
			if (p.contains("$")) {
				String actualData = p.substring(1);
				System.out.println(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}

		}

		for (int i = 0; i < array.size() - 1; i++) {

			if (array.get(i) < array.get(i + 1)) {
				System.out.println("obj.get(i):-" + array.get(i));
				System.out.println("obj.get(i+1):-" + array.get(i + 1));
			} else {
				Assert.assertTrue(false);
			}
		}
	}
}
