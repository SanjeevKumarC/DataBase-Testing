package mpack;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CheckTheAppInstalledOrNot {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String packageToCheck = "com.example.myba";
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("appPackage", "com.example.mybank");
		dc.setCapability("appActivity", "com.example.mybank.SplashScreenLayout");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, dc);
		// boolean isInstalled = false;
		/*
		 * try { isInstalled = driver.isAppInstalled(packageToCheck); if (isInstalled) {
		 * System.out.println("The APK is installed on the device"); } else {
		 * System.out.println("The APK is not installed on the device"); } } catch
		 * (Exception e) { System.out.println(e.getMessage()); }
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		String appName = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.example.mybank:id/RecyclerViewAppG']//android.widget.TextView";
		List<WebElement> app = driver.findElements(By.xpath(
				"//androidx.recyclerview.widget.RecyclerView[@resource-id='com.example.mybank:id/RecyclerViewAppG']//android.widget.TextView"));
		for (WebElement we : app) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appName)));
			driver.findElement(By.xpath(appName)).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Uninstall']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='OK']")))
					.click();

		}
		System.out.println("done");

	}

}
