package Interview;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.navigate().to("file:///C:/Users/ADMIN/Downloads/Alert.html");
		WebElement tryIt = d.findElement(By.xpath("//button"));
		tryIt.click();
		Alert alt = d.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		WebElement message = d.findElement(By.id("demo"));
		System.out.println(message.getText());
		tryIt.click();
		d.switchTo().alert().dismiss();
		System.out.println(message.getText());

	}

}
