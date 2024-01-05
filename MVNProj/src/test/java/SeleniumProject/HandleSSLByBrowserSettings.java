package SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSLByBrowserSettings {

	public static void main(String[] args) {

		/*
		 * //Not Secure or Private website handling ChromeOptions co=new
		 * ChromeOptions(); co.setAcceptInsecureCerts(true); ChromeDriver driver=new
		 * ChromeDriver(co); driver.manage().window().maximize();
		 * driver.get("https://captive-portal.badssl.com/");
		 */

		// Run the script in Headless mode
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	    driver.quit();	
	}

}
