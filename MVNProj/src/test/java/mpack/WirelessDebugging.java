package mpack;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WirelessDebugging extends RunCommandPrompt {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// Enable the wireless debugging
		RunCommandPrompt cmd = new RunCommandPrompt();
		cmd.command = "adb devices";
		ArrayList<String> res = cmd.executeCommand();
		res.forEach(a -> System.out.println(a));

		// app open
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.example.mybank");
		cap.setCapability("appActivity", "com.example.mybank.SplashScreenLayout");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ArrayList<String> popupText = new ArrayList<String>();
		String skip = "//android.widget.Button[contains(@resource-id,':id/btn_sdk_btn_ignore')]";
		String pop = "//android.widget.TextView[contains(@resource-id,':id/tv_sdk_title')]"; //
		String heading = "Admin Permission Detection";
		try {
			while (true) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(skip)));
				if (!driver.findElement(By.xpath(skip)).isDisplayed())
					break;
				String text = driver.findElement(By.xpath(pop)).getText();
				// if(text.trim().equals(heading))
				// break; popupText.add(text);
				driver.findElement(By.xpath(skip)).click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		popupText.forEach(a -> System.out.println(a));

	}

}
