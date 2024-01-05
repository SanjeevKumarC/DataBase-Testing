package mpack;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class seekBar {
	public static void main(String[] args) {
        // Set up desired capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "your_device_name");
        desiredCapabilities.setCapability("appPackage","com.upgrad.student");
        desiredCapabilities.setCapability("appActivity","com.upgrad.student.unified.ui.splash.activities.SplashScreenActivity");

        // Create Appium driver instance
        AndroidDriver  driver;
        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Careers']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Filter']")).click();

        // Locate the sleek bar element
           WebElement sleekBar = driver.findElement(By.id("com.upgrad.student:id/rangeSeekBar"));

        // Set the value of the sleek bar directly
        double desiredPercentage = 50.0; // Example: moving the slider to the middle
        // sleekBar.setValue(String.valueOf(desiredPercentage));

        // Perform further actions or verifications

        // Close the driver session
        driver.quit();
    }
}
