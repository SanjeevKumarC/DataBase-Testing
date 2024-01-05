package mpack;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Demo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("appPackage", "in.a23.rummy");
		dc.setCapability("appActivity", "com.rummy.activity.SplashActivity");

		URL url = new URL("http://localhost:4723/wd/hub");
		AppiumDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement closePopup = driver.findElement(By.xpath(
				"//android.widget.FrameLayout[@resource-id=\"in.a23.rummy:id/inapp_half_interstitial_image_frame_layout\"]/android.widget.ImageView"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(closePopup));
		closePopup.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='sanjeev...']")).click();

//		Dimension screenSize = driver.manage().window().getSize();//Identify screen dimension
//		int screenCenter = (int) (screenSize.getWidth()*0.5);//Identify center point of screen for Y axis
//		int startPoint = (int) (screenSize.getHeight()*0.5);//Identify beginning point of scroll for X axis
//		int endPoint = (int) (screenSize.getHeight()*0.2);//Identify ending point of scroll
//		int count = 0;			
//		System.out.println(screenCenter +" "+startPoint+" "+ endPoint);

		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		// Set start and end coordinates for the scroll action
		int startX = size.width / 2;
		System.out.println(startX);
		int startY = (int) (size.height * 0.8);
		System.out.println(startY);
		int endY = (int) (size.height * 0.2);
		System.out.println(endY);
//		TouchAction touchAction = new TouchAction<>(driver);
//		touchAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//				.moveTo(PointOption.point(startX, endY)).release().perform();

//		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//
//		//Search Element until it is available on screen. If no, then perform below operations
//		while (driver.findElements(By.xpath("//android.widget.TextView[@text='Security']")).isEmpty()) {
//			Sequence swipe =  new Sequence(finger, 1);
//
//			//Move finger into starting position
//			swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), screenCenter, startPoint));
//
//
//			//Finger goes up into contact with screen
//			swipe.addAction(finger.createPointerDown(0));
//
//			//Finger moves to End Position
//			swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), screenCenter, endPoint));
//
//			//Take out finger from screen
//			swipe.addAction(finger.createPointerUp(0));
	}
}
