package selenium;

import java.awt.image.BufferedImage;
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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ImageCompareBasedOnFixel {

	/*
2880
1466
2880
1472
	 */
	public boolean compareImage(String fileone, String filetwo) throws IOException {
		BufferedImage imgA = ImageIO.read(new File(fileone));
		BufferedImage imgB = ImageIO.read(new File(filetwo));
		System.out.println(imgA.getWidth());
		System.out.println(imgA.getHeight());
		System.out.println(imgB.getWidth());
		System.out.println(imgB.getHeight());
		if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
			for (int x = 0; x < imgA.getWidth(); x++) {
				for (int y = 0; y < imgA.getHeight(); y++) {
					int rgb1 = imgA.getRGB(x, y);
					int rgb2 = imgB.getRGB(x, y);
					
					if (rgb1!=rgb2){
						System.out.println(rgb1);
						System.out.println(rgb2);
						System.out.println("pixel issue");
						return false;
					}
				}
			}
		} else {
			System.out.println("size issue");
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/seleniumgrid/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.tirerack.com/content/tirerack/desktop/en/homepage.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);
        FileUtils.copyFile(screenshot, new File("tirerack.jpg"));
		ImageCompareBasedOnFixel obj = new ImageCompareBasedOnFixel();
		boolean returnData = obj.compareImage("tirerack.jpg", "tirerackInput.jpg");
		if(returnData){
			System.out.println("Test is pass");
		}
		else{
			System.out.println("Test is FAil");
		}
		driver.quit();
	}

}
