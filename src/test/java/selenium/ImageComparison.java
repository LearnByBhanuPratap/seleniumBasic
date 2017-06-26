package selenium;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ImageComparison {

	public WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		// for Mac OS
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
		// For Window OS
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
	}

	@Test
	public void testImageComparison() throws IOException, InterruptedException {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		FileUtils.copyFile(screenshot, new File("FacebookOutput.jpg"));

		File fileInput = new File("FacebookInput.jpg");
		File fileOutPut = new File("FacebookOutput.jpg");

		BufferedImage bufferfileInput = ImageIO.read(fileInput);
		DataBuffer bufferfileInput1 = bufferfileInput.getData().getDataBuffer();
		int sizefileInput = bufferfileInput1.getSize();
		System.out.println(sizefileInput);

		BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
		DataBuffer bufferfileOutPut1 = bufferfileOutPut.getData().getDataBuffer();
		int sizefileOutPut = bufferfileOutPut1.getSize();
		System.out.println(sizefileOutPut);
		
		Boolean matchFlag = true;
		if (sizefileInput == sizefileOutPut) {
			for (int i = 0; i < sizefileInput; i++) {
				if (bufferfileInput1.getElem(i) != bufferfileOutPut1.getElem(i)) {
					matchFlag = false;
					System.out.println(bufferfileInput1.getElem(i));
					System.out.println(bufferfileOutPut1.getElem(i));
					System.out.println("------");
					break;
				}
			}
			Assert.assertTrue(matchFlag, "Images are not same");
		} else {
			matchFlag = false;
			Assert.assertTrue(matchFlag, "Images are not same");
		}
		
	}
	

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
	}

}
