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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MyDemoApp {
	@Test

	public static void main(String args[]) throws MalformedURLException, URISyntaxException, InterruptedException {

		UiAutomator2Options options = new UiAutomator2Options().setPlatformName("Android").setPlatformVersion("7.0")
				.setAutomationName("UiAutomator2").setDeviceName("emulator-5554")
				.setApp("C:\\Users\\rithi\\Downloads\\commcare\\commcare\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244 (1).apk");
				

		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\rithi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(10)).build();

		URL serverURL = new URL("http://127.0.0.1:4723");

		AndroidDriver driver = new AndroidDriver(serverURL, options);
		driver.findElement(By.xpath(
				"(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView"))
				.click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add To Cart\"));"));
		

		
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView"))
				.click();
		driver.findElement(By.xpath(
				"//android.widget.TextView[@text=\"Add To Cart\"]"))
				.click();
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"))
				.click();
		driver.findElement(By.xpath(
				"//android.widget.TextView[@text=\"Proceed To Checkout\"]"))
				.click();
		driver.findElement(
		By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"))
		.sendKeys("bob@example.com");
		
		driver.findElement(
		By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"))
		.sendKeys("10203040");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
		
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]"))
				.sendKeys("My Name");
		driver.findElement(
				By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]"))
				.sendKeys("Street 123");
		

		
		driver.findElement(AppiumBy.androidUIAutomator(
		         "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"City*\").instance(0))")).click();
		
		driver.findElement(
				By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]"))
				.sendKeys("New York");
		driver.findElement(
				By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]"))
				.sendKeys("10001");
		driver.findElement(
				By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]"))
				.sendKeys("United States");
		
		driver.findElement(By.xpath(
				"//android.widget.TextView[@text=\"To Payment\"]"))
				.click();
		
		String Expected = driver.findElement(By.xpath(
				"//android.widget.TextView[@text=\"Enter a payment method\"]")).getText();
		Assert.assertEquals(Expected, "Enter a payment method");
		System.out.println(Expected);
		String Expected2 = driver.findElement(By.xpath(
				"//android.widget.TextView[@text=\"Review Order\"]")).getText();
		Assert.assertEquals(Expected2, "Review Order");
		System.out.println(Expected2);
		
		driver.quit();
		service.stop();

	}
}
