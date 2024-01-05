package mpack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class captacha {

	public static void main(String[] args) throws InterruptedException, TesseractException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.payworldindia.com/retailer");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement img = driver.findElement(By.xpath("//img[@id='captchaImg']"));
		wait.until(ExpectedConditions.visibilityOf(img));

		File screenshot = img.getScreenshotAs(OutputType.FILE);
		File desti = new File("./TestData/captacha.png");
		FileUtils.copyFile(screenshot, desti);
		String cap = desti.toString();
		File file = new File(cap);
		Tesseract tes = new Tesseract();
		String text = tes.doOCR(file);
		text=text.replace(" ","").replaceAll("[^a-zA-Z0-9]", "");  
		System.out.println(text);
		driver.findElement(By.xpath("//input[@id='captchatxt']")).sendKeys(text);
		//driver.close();
		

	}

}
