import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class PopupIsdisplayed {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("appPackage", "com.example.mybank");
		dc.setCapability("appActivity", "com.example.mybank.SplashScreenLayout");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);
		String xpathToTapOnElement = "//android.widget.Button[contains(@resource-id,':id/btn_sdk_btn_ignore')]";
		String xpathToReturnTextFromTheElement = "//android.widget.TextView[contains(@resource-id,':id/tv_sdk_title')]";

		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			try {
				while (driver.findElement(By.xpath(xpathToTapOnElement)).isDisplayed()) {
					String getText = driver.findElement(By.xpath(xpathToReturnTextFromTheElement)).getText();
					arrayList.add(getText);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToTapOnElement))).click();
				}
			} catch (NoSuchElementException e) {
				Collections.reverse(arrayList);
				int count=arrayList.size();
				System.out.println(count);
			}

		} catch (Exception e) {
			if (arrayList.isEmpty())
				arrayList.add(driver.findElement(By.xpath(xpathToReturnTextFromTheElement)).getText());	
		}
		System.out.println(arrayList);	
	}
}