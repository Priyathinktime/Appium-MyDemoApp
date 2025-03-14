package sci.commcare;

import java.io.File;
import java.net.MalformedURLException;

import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class My_Demo_App_iOS {
	@Test

	public static void main(String args[]) throws MalformedURLException, URISyntaxException, InterruptedException {


UiAutomator2Options options = new UiAutomator2Options().setPlatformName("iOS").setPlatformVersion("18.3")
				.setAutomationName("XCUITest").setDeviceName("iPhone 16")
				.setApp("C:\\Users\\rithi\\Downloads\\commcare\\commcare\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244 (1).apk");
				

		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\rithi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(10)).build();

		URL serverURL = new URL("http://127.0.0.1:4723");

		IOSDriver driver = new IOSDriver(serverURL, options);




		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Sauce Labs Backpack']")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add To Cart\"));"));
		

		
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='counter plus button']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Add To Cart button']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='cart badge']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Proceed To Checkout button']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Username input field']")).sendKeys("bob@example.com");
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Password input field']")).sendKeys("10203040");
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Login button']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Full Name* input field']")).sendKeys("My Name");
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Address Line 1* input field']")).sendKeys("Street 123");
	
driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"City*\").instance(0))")).click();
		
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='City* input field']")).sendKeys("New York");
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Zip Code* input field']")).sendKeys("10001");
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Country* input field']")).sendKeys("United States");
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name='To Payment']")).click();
		String Expected = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Enter a payment method']")).getText();
		Assert.assertEquals(Expected, "Enter a payment method");
		System.out.println(Expected);
		String Expected2 = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Review Order']")).getText();
		Assert.assertEquals(Expected2, "Review Order");
		System.out.println(Expected2);
		
		driver.quit();
		service.stop();

    
	}
}
