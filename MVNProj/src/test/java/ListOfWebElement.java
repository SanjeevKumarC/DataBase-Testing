import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ListOfWebElement {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String input="2";
		driver.get("https://dat.kuza.one/dat/ke/one/#/aggregation/buy");
		Thread.sleep(7000);
		System.out.println("starts");
		Shadow s=new Shadow(driver);
		System.out.println("shadowed");
		List<WebElement> textfield = s.findElementsByXPath("//ion-input//input[@type='number' and not(@disabled)]");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Robot robot=new Robot();
		System.out.println("shadowed");
		System.out.println(textfield.size());
		//Actions act=new Actions(driver);
		for (WebElement we : textfield) {
			System.out.println("forloop");
			System.out.println(we.getAttribute("type"));
			//js.executeScript("arguments[0].click();", we);
			
		}
		
		System.out.println("Completed");

	}

}
