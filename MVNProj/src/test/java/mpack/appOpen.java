package mpack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class appOpen {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("appPackage", "com.example.mybank");
		dc.setCapability("appActivity", "com.example.mybank.SplashScreenLayout");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, dc);
		//Thread.sleep(5000);
//		ArrayList<String> popupText = new ArrayList<String>();
//		String skip = "//android.widget.Button[contains(@resource-id,':id/btn_sdk_btn_ignore')]";
//		String pop = "//android.widget.TextView[contains(@resource-id,':id/tv_sdk_title')]";
//		String heading = "Admin Permission Detection";
//		try {
//			while (true) {
//				if (!driver.findElement(By.xpath(skip)).isDisplayed())
//					break;
//				String text = driver.findElement(By.xpath(pop)).getText();
//				if (text.trim().equals(heading))
//					break;
//				popupText.add(text);
//				driver.findElement(By.xpath(skip)).click();
//				Thread.sleep(500);
//			}
//		} catch (Exception e) {
//			
//		}
		
//	if(driver.isAppInstalled("com.evezzon.fa"))
//		System.out.println("installed");
//	else
//		System.out.println("not");
//		System.out.println(popupText);
	}

}
