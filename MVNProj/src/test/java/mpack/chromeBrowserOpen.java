package mpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeBrowserOpen {

	public static void main(String[] args) {
		System.setProperty(null, null);
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.switchTo().activeElement();
		
		
		
	
		
		
		
     
	}
}
