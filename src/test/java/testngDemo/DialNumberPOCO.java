package testngDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DialNumberPOCO {

	private AndroidDriver driver;


	@BeforeMethod
	public void setUp() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("appium:deviceName", " POCO M2 Pro");
		desiredCapabilities.setCapability("appium:appPackage", "com.android.contacts");
		desiredCapabilities.setCapability("appium:appActivity", "com.android.contacts.activities.TwelveKeyDialer");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4445/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println(driver.getSessionId());

	}
	
	@Test
	public void DialTestPoco() throws InterruptedException {

		MobileElement el1 = (MobileElement) driver.findElement(By.id("com.android.contacts:id/five"));
		el1.click();

		MobileElement el2 = (MobileElement) driver.findElement(By.id("com.android.contacts:id/four"));
		el2.click();

		MobileElement el3= (MobileElement) driver.findElement(By.id("com.android.contacts:id/three"));
		el3.click();

		MobileElement el4 = (MobileElement) driver.findElement(By.id("com.android.contacts:id/two"));
		el4.click();

		MobileElement el5 = (MobileElement) driver.findElement(By.id("com.android.contacts:id/call_button_container"));
		el5.click();

		Thread.sleep(5000);	

	}
	 @AfterMethod
	  public void tearDown() throws Throwable {
		  Thread.sleep(20000);
	    driver.quit();
	 }
	
}
