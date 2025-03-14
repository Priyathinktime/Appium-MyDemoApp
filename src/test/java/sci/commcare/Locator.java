package sci.commcare;


	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
	import io.appium.java_client.service.local.AppiumDriverLocalService;
	import io.appium.java_client.service.local.AppiumServiceBuilder;
	import io.appium.java_client.AppiumBy;
	import org.openqa.selenium.By;
	import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URISyntaxException;
	import java.net.URL;
	import java.time.Duration;

	public class Locator  {
	    public static void main(String[] args) throws MalformedURLException, URISyntaxException, InterruptedException {

	        // Set Appium options
	        UiAutomator2Options options = new UiAutomator2Options()
	                .setPlatformName("Android")
	                .setPlatformVersion("7.0")
	                .setAutomationName("UiAutomator2")
	                .setDeviceName("emulator-5554")
	                .setApp("C:\\Users\\rithi\\Downloads\\commcare\\commcare\\src\\test\\java\\resources\\Android-MyDemoAppRN.apk"); // Ensure the file path is correct
	        
	        // Start Appium Server
	        AppiumDriverLocalService service = new AppiumServiceBuilder()
	                .withAppiumJS(new File("C:\\Users\\rithi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	                .withIPAddress("127.0.0.1")
	                .usingPort(4723)
	                .withTimeout(Duration.ofSeconds(10))
	                .build();
	        
	        service.start();  // Start the Appium server

	        // Define the server URL
	        URL serverURL = new URL("http://127.0.0.1:4723");

	        // Initialize AndroidDriver
	        AndroidDriver driver = new AndroidDriver(serverURL, options);

	        // Perform click action on first store item
	        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='store item'])[1]/android.view.ViewGroup[1]/android.widget.ImageView"))
	                .click();

	        // Scroll to element and click
	        driver.findElement(AppiumBy.androidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true))" +
	                ".scrollIntoView(new UiSelector().description(\"counter plus button\"))")).click();

	        // Close driver after execution
	        Thread.sleep(3000); // Wait for a few seconds to observe results
	        driver.quit();
	        service.stop(); // Stop the Appium server
	    }
	}
