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

public class captcha2 {

	public static void main(String[] args) throws InterruptedException, TesseractException, IOException {
		System.setProperty("webdriver.chrome.driver", "./TestData/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.videocx.io/login3");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement img = driver.findElement(By.xpath("//img[@id='captchaImage']"));
//		wait.until(ExpectedConditions.visibilityOf(img));
//
//		File screenshot = img.getScreenshotAs(OutputType.FILE);
//		File desti = new File("./TestData/captacha.png");
//		FileUtils.copyFile(screenshot, desti);
//		String cap = desti.toString();
//		File file = new File(cap);
//		Tesseract tes = new Tesseract();
//		String text = tes.doOCR(file);
//		text=text.replace(" ","").replaceAll("[^a-zA-Z0-9]", "");  
//		System.out.println(text);
//		driver.findElement(By.xpath("//input[@id='captchaCode']")).sendKeys(text);

		/* Captcha for IRCTC Application */

		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@aria-label='Click here to Login in application']")))).click();
		WebElement img = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		wait.until(ExpectedConditions.visibilityOf(img));

		File screenshot = img.getScreenshotAs(OutputType.FILE);
		File desti = new File("./TestData/captacha.png");
		FileUtils.copyFile(screenshot, desti);
		String cap = desti.toString();
		File file = new File(cap);
		Tesseract tes = new Tesseract();
		String text = tes.doOCR(file); 
		System.out.println(text);
		driver.findElement(By.id("captcha")).sendKeys(text);

		/* Captcha 3 */

		/*
		 * driver.get("https://epaylater.keka.com/careers/applyjob/14995");
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 * 
		 * //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("//a[@aria-label='Click here to Login in application']"))).click();
		 * WebElement img = driver.findElement(By.xpath("//img[@id='imgCaptcha']"));
		 * wait.until(ExpectedConditions.visibilityOf(img));
		 * 
		 * File screenshot = img.getScreenshotAs(OutputType.FILE); File desti = new
		 * File("./TestData/captacha.png"); FileUtils.copyFile(screenshot, desti);
		 * System.out.println(desti); String cap = desti.toString();
		 * System.out.println(cap); File file = new File(cap); Tesseract tes = new
		 * Tesseract(); String text = tes.doOCR(file); System.out.println(text);
		 * driver.findElement(By.id("captcha")).sendKeys(text);
		 */

	}

}
