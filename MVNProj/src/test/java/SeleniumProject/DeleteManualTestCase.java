package SeleniumProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteManualTestCase {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.get("https://product.fireflink.com/");
	//FireFlink UserName
	driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("sanjeev@mailinator.com");
	//FireFlink Password
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Testing@123");
	driver.findElement(By.className("primary-btn")).submit();
	//Project Name
	String proName="MyBank";
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+proName+"']"))).click();
	//Module Name
    String modName="Equitas - IOS";
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+modName+"']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root']"))).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Manual']")));
    List<WebElement> manual = driver.findElements(By.xpath("//button[text()='Manual']"));
    Actions act=new Actions(driver);
    System.out.println(manual.size());
    int size=1;
 for (int i = 0; i <= manual.size(); i++) {
     List<WebElement> manual1 = driver.findElements(By.xpath("//button[text()='Manual']"));
     size=manual1.size();
     System.out.println(size);
	 act.moveToElement(manual1.get(i)).perform();
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Manual']/../../..//*[name()='svg' and @title='Delete']"))).click();
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='deleteManualScript']"))).click();
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Delete']"))).click();
     Thread.sleep(4000);
     i=0;
 }
 System.out.println("done");
}
 
}
