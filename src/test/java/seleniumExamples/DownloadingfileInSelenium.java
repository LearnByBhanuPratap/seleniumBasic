package seleniumExamples;

import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadingfileInSelenium {
	WebDriver driver;

	@BeforeTest
	public void StartBrowser() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/drivers/geckodriver.exe");
		// about:config
		// Create object of FirefoxProfile in built class to access Its
		// properties.
		FirefoxProfile fprofile = new FirefoxProfile();
		/**
		 * How to Use browser.download.folderList The value of
		 * browser.download.folderList can be set to either 0, 1, or 2. 
		 * When set to 0, Firefox will save all files downloaded via the browser on the
		 * user's desktop. 
		 * When set to 1, these downloads are stored in the
		 * Downloads folder. 
		 * When set to 2, the location specified for the most
		 * recent download is utilized again.
		 */
		// Set Location to store files after downloading.
		fprofile.setPreference("browser.download.dir", "/Users/bsingh5/Downloads");
		fprofile.setPreference("browser.download.folderList", 2);
		// Set Preference to not show file download confirmation dialogue using
		// MIME types Of different file extension types.
		fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;" // MIME Type of Excel
						+ "application/pdf;" // MIME types Of PDF File.
						+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" // MIME types Of MS doc File.
						+ "text/plain;" // MIME types Of text File.
						+ "text/csv;"
						+ "application/zip;" 
						+ "application/x-gzip;"); // MIME Type of Tar file

		/**
		 * A boolean value that indicates whether or not to show the Downloads
		 * window when a download begins. The default value is true.
		 */
		fprofile.setPreference("browser.download.manager.showWhenStarting", false);
		/**
		 * You can set the pdfjs.disabled pref to true on the about:config page
		 * to disable the build-in PDF viewer and use the Adobe Reader instead.
		 */
		fprofile.setPreference("pdfjs.disabled", true);
		// Pass fprofile parameter In webdriver to use preferences to download
		// file.
		driver = new FirefoxDriver(fprofile);
	}

	@Test
	public void OpenURL() throws InterruptedException {
		
		File f = new File("/Users/bsingh5/Downloads/eclipse-inst-mac64.tar.gz");
		if (f.exists()) {
			f.delete();
			System.out.println("file deleted");
		}
		
		driver.get("https://www.eclipse.org/downloads/");
		driver.findElement(By.xpath("//*[contains(text(),'Download 64 bit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='novaContent']/div[1]/div[1]/div/div/a")).click();
		Thread.sleep(5000);

		File file = new File("/Users/bsingh5/Downloads/eclipse-inst-mac64.tar.gz");
		int count = 0;
		System.out.println(file.exists());
		
		while (!file.exists()) {
			System.out.println("waiting for download to complete....." + count++);
			Thread.sleep(2000);
		}
		
		File f1 = new File("/Users/bsingh5/Downloads/eclipse-inst-mac64.tar.gz");

		long file1;
		do {
			file1 = f1.length(); // check file size
			System.out.println(file1);
			Thread.sleep(8000); // wait for 5 seconds
		} while (file1 == 0);

		f = new File("/Users/bsingh5/Downloads/eclipse-inst-mac64.tar.gz");
		if (f.exists() && file1>0) {
			System.out.println("Test is pass");
		} else {
			System.out.println("Test is fail");
		}
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.quit();
	}
}
