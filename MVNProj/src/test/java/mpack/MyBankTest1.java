package mpack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MyBankTest1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("appPackage","com.example.mybank");
		cap.setCapability("appActivity","com.example.mybank.SplashScreenLayout");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("deviceName","Pixel 5 API 30");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver= new AndroidDriver(url, cap);
		System.out.println("started");
		Thread.sleep(7000);
		System.out.println(driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,':id/tv_sdk_title')]")).getText());
	driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,':id/btn_sdk_btn_ignore')]")).click();
	Thread.sleep(2000);
	System.out.println(driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,':id/tv_sdk_title')]")).getText());

	}
	

}
