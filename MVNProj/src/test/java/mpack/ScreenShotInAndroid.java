package mpack;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;


public class ScreenShotInAndroid {

	public static void main(String[] args) throws IOException {
		DesiredCapabilities cap=new DesiredCapabilities();
		//cap.setCapability("appPackage","com.amazon.sellermobile.android");
		//cap.setCapability("appActivity","com.amazon.mShop.home.MainActivity");
		cap.setCapability("platformName", "Android");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver= new AndroidDriver(url, cap);
		System.out.println("started");
		//File screenshot=driver.getScreenshotAs(OutputType.FILE);
		//WebElement ele = driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE APP']"));
		//ele.click();
		System.out.println("Element found");
		File screenshot=driver.getScreenshotAs(OutputType.FILE);
		//File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(screenshot);
		File org=new File("./TestData/screen.png");
		FileUtils.copyFile(screenshot,org);
		System.out.println("complete");
	
		

	}

}
