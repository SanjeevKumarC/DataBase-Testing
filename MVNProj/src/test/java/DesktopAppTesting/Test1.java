package DesktopAppTesting;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class Test1 {
	private static WindowsDriver notepadSession = null;
	public static void main(String[] args) {
		//Using WinAppDriver
		try {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability("app", "C:\\Windows\\notepad.exe");
		 capabilities.setCapability("platformName","Windows");
		 capabilities.setCapability("deviceName", "WindowsPC");
		 capabilities.setCapability("ms:experimental-webdriver", true);
		 notepadSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
		 notepadSession.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		} catch (Exception e) {
		 e.printStackTrace();
		  }
		 }



}
