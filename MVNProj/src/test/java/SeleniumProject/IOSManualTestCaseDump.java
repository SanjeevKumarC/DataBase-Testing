package SeleniumProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class IOSManualTestCaseDump {
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
	    String modName="Suryoday-IOS";
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+modName+"')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='root-btn exapnd-all-btn ml-3']"))).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='fancytree-title tree-folder-title-repo-module-width']")));
	    List<WebElement> listOfScript = driver.findElements(By.xpath("//*[@class='fancytree-title tree-folder-title-repo-module-width']"));
        System.out.println(listOfScript.size());
	    try {
		 for (int i = 0; i <listOfScript.size() ; i++) {//listOfScript.size()
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='fancytree-title tree-folder-title-repo-module-width']")));
			listOfScript = driver.findElements(By.xpath("//*[@class='fancytree-title tree-folder-title-repo-module-width']"));
			String text=listOfScript.get(i).getText();
			System.out.println(text);
			listOfScript.get(i).click();
			DumpManualTestCase(driver,wait,text,modName);
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Completed....");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+modName.substring(0,6)+"')]"))).click();
	    
		driver.quit();
  }

	private static void DumpManualTestCase(WebDriver driver, WebDriverWait wait, String text, String modName) throws InterruptedException {
		Set<Entry<String, String>> mp = getTestCaseProxy(text,modName.substring(0,modName.indexOf('-')));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Manual Test Case')]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ml-auto pl-4']//button")));
		if(driver.findElement(By.xpath("//div[@class='ml-auto pl-4']//button")).getText().equals("Edit")){
			driver.findElement(By.xpath("//div[@class='ml-auto pl-4']//button")).click();
		}
		Thread.sleep(2000);
		for (int i = 3; i <mp.size(); i++) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Insert row below']"))).click();
		}
		driver.findElement(By.xpath("//td[3]")).sendKeys(".");
		driver.findElement(By.xpath("//td[3]")).clear();
		driver.findElement(By.xpath("//td[3]")).sendKeys(text.substring(text.indexOf('_')+1,text.length()).trim());
	     
		  int inc=0;
			for (Map.Entry<String, String> val : mp) {
				
				driver.findElement(By.xpath("(//td[2])["+ ++inc +"]")).sendKeys(inc+"");
				driver.findElement(By.xpath("(//td[5])["+ inc +"]")).sendKeys("N/A");
				driver.findElement(By.xpath("(//td[6])["+ inc +"]")).sendKeys(val.getKey());
				driver.findElement(By.xpath("(//td[7])["+ inc +"]")).sendKeys(val.getValue());		
			}	
			
			 driver.findElement(By.xpath("(//td[4])[1]")).sendKeys(getPrecondition(text.substring(text.indexOf('0'),text.indexOf('_'))));
			 driver.findElement(By.xpath("(//td[4])[6]")).sendKeys(getPrecondition(text.substring(text.indexOf('0'),text.indexOf('_'))).replace("manual","none").replace("should be","should not be").replace("should not be locked","should be locked").replace("should not be installed","should be installed").replace("should be connected with unsecured Wi-Fi","should be connected with secured Wi-Fi"));
			 
		driver.findElement(By.id("Requirement Id")).sendKeys(text.substring(0,text.indexOf('_')));
        driver.findElement(By.id("Created by")).sendKeys("Sanjeev Kumar C");
        driver.findElement(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium mt-1 css-vubbuv']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='20']"))).click();
        driver.findElement(By.xpath("//input[@id='Reviewed by']")).sendKeys("Dhanush");
        driver.findElement(By.xpath("(//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium mt-1 css-vubbuv'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='22']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Save']"))).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+modName.substring(0,5)+"')]"))).click();	
   }
	private static  Set<Entry<String, String>> getTestCaseProxy(String text, String appName) {
		LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();
		map.put("Launch "+ appName +" App","User Should able to Open "+ appName +" App");
		map.put("Tap On Skip button Until The "+getPopupvalue(text.substring(text.indexOf('0'),text.indexOf('_'))) +" Popup Is Visible","User should able to Tap On Skip button Until The "+getPopupvalue(text.substring(text.indexOf('0'),text.indexOf('_'))) +" Popup Is Visible");
		map.put("Tap on SKIP button","User should able to Tap on SKIP button");
		map.put("Verify "+getPopupvalue(text.substring(text.indexOf('0'),text.indexOf('_'))) +" title is not displayed",getPopupvalue(text.substring(text.indexOf('0'),text.indexOf('_'))) +" title should not be displayed");
		map.put("close "+ appName +" App","User Should able to close "+ appName +" App");
		map.put("Launch "+ appName +" App ","User Should able to Open "+ appName +" App");
		map.put("Verify "+getPopupvalue(text.substring(text.indexOf('0'),text.indexOf('_'))) +" Popup is not displayed",getPopupvalue(text.substring(text.indexOf('0'),text.indexOf('_'))) +" should not be displayed");
		map.put("close "+ appName +" App ","User Should able to close "+ appName +" App");
		return map.entrySet();
	}
	private static String getPopupvalue(String key) {
		Map<String,String> map=new LinkedHashMap<String,String>();
		map.put("001","Proxy Check");
		map.put("002","VPN Connection Check");
		map.put("003","Screen Mirroring Detection");
		map.put("004","Unsecured wifi");
		map.put("005","App Installation Source");
		map.put("006","Enabled Device Screen Lock");
		return map.get(key);
	}
	private static String getPrecondition(String key) {
		Map<String,String> map=new LinkedHashMap<String,String>();
		map.put("001","Enable the wifi and change the Proxy  to manual");
		map.put("002","VPN should be connected");
		map.put("003","Mobile screen should be in sharing");
		map.put("004","Device should be connected with unsecured Wi-Fi");
		map.put("005","Application should not be installed from secured source");
		map.put("006","Device should not be locked");
		
		return map.get(key);
	}
}
