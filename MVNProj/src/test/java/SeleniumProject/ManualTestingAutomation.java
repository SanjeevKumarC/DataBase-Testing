package SeleniumProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManualTestingAutomation {

	public static void main(String[] args) throws InterruptedException {
		
	   /*  ______________________________________________________________________________________________________________
		  |                                                                                                              |
		  | Test Case Name       Requirement Id       Status                                                             |
		  | XXXXXXXXXXXX          XXXXXX               XXXX                                                              |
		  |                                                                                                              |
		  | Created By           Created On          Reviewed By                                                         |
		  | XXXXX                 XXXXX                XXXXX                                                             |
		  |                                                                                                              |
		  | Reviewed On                                                                                                  |
		  | XXXXX                                                                                                        |
		  |  __________________________________________________________________________________________________________  |
		  | |    |SL No|Test Case ID|Test Description|Test Data|Test Step|Expected Result|Actual Result|Status|Comments| |
		  | |____|_____|____________|________________|_________|_________|_______________|_____________|______|________| |
		  |______________________________________________________________________________________________________________|  
		*/
		
//		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--headless");
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
	    String modName="MyBank - Android";
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+modName+"']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root']"))).click();
	    String subMod="A004 Proxy";
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+subMod+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title and contains(@class,'repo')]")));
		 List<WebElement> listOfScript = driver.findElements(By.xpath("//span[@title and contains(@class,'repo')]"));
		try {
		 for (int i = 0; i <listOfScript.size() ; i++) {//listOfScript.size()
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@title and contains(@class,'repo')]")));
			List<WebElement> listOf = driver.findElements(By.xpath("//span[@title and contains(@class,'repo')]"));
			System.out.println(listOf.get(i).getText());
			String text=listOf.get(i).getText();
			listOf.get(i).click();
			DumpManualTestCase(driver,wait,text,subMod);
		}
		} catch (Exception e) {
		}
		System.out.println("Complted....");
		 driver.quit();
	}

	private static void DumpManualTestCase(WebDriver driver, WebDriverWait wait, String text, String modName) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='step-break']")));
		List<WebElement> steps = driver.findElements(By.xpath("//span[@id='step-break']"));
		List<String> allSteps = new ArrayList<>();
		List<String> s1 = new ArrayList<>();
		//"OpenBrowser", "Enter", "Click on","Verify", "CloseBrowser"
		ArrayList<String> all = new ArrayList<>(Arrays.asList("Launch App","SKIP and Verify","While Loop","CLOSE APP","Verify the Popup","Wait for wait seconds","Get ScreenShot","App close","Close Android App"));
		for (WebElement st : steps) {
			allSteps.add(st.getText());
		}
		for (int i = 0; i < allSteps.size(); i++) {
			for (String s : all) {
				if (allSteps.get(i).contains(s))
					s1.add(allSteps.get(i).toString().replace("- Step Group", ""));
			}
		}
		ArrayList<String> al1 = new ArrayList<String>();
		String statement = "User should able to";
		String print = "should not be";
		for (int i = 0; i < s1.size(); i++) {
			if (s1.get(i).toLowerCase().toString().contains("not")) {
				al1.add(s1.get(i).toString().replace("is not", "should not be").replace("- Step Group", "").replace("Verify the","").replace("if", "").replace("Android_Check If","User should "));
			} else if(s1.get(i).toLowerCase().toString().contains("while loop"))
				al1.add("The Element Is Present In The DOM And Clicked  And Returned The Order Of PopUps");
			else
				al1.add(statement + " ".concat((String) s1.get(i)).replace("- Step Group", ""));
		}
		Map<String, String> hm = new LinkedHashMap<>();
		for (int i = 0; i < al1.size(); i++) {
			
			if(!s1.get(i).equals("App close") && i==0)
			{
			   hm.put(s1.get(i), al1.get(i));
			}
			else if(i>=1){
				hm.put(s1.get(i), al1.get(i));
			}
	
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Manual Test Case')]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ml-auto pl-4']//button")));
		if(driver.findElement(By.xpath("//div[@class='ml-auto pl-4']//button")).getText().equals("Edit")){
			driver.findElement(By.xpath("//div[@class='ml-auto pl-4']//button")).click();
		}
		Thread.sleep(2000);
		for (int i = 3; i <hm.size(); i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Insert row below']"))).click();
		}
		
		driver.findElement(By.xpath("//td[3]")).sendKeys(text.substring(0,text.indexOf(' ')));
		driver.findElement(By.xpath("//td[4]")).sendKeys(text.substring(text.indexOf(' '),text.length()).trim());
		//driver.findElement(By.xpath("//td[3]")).sendKeys(text.substring(1,text.indexOf(' ')));
        int inc=0;
		for (Entry<String, String> map : hm.entrySet()) {
			driver.findElement(By.xpath("(//td[2])["+ ++inc +"]")).sendKeys(inc+"");
			driver.findElement(By.xpath("(//td[5])["+ inc +"]")).sendKeys("N/A");
			driver.findElement(By.xpath("(//td[6])["+ inc +"]")).sendKeys(map.getKey().trim());
			driver.findElement(By.xpath("(//td[7])["+ inc +"]")).sendKeys(map.getValue().trim());
		}
		
		
		driver.findElement(By.id("Requirement Id")).sendKeys(text.substring(0,text.indexOf(' ')));
        driver.findElement(By.id("Created By")).sendKeys("Sanjeev kumar");
        driver.findElement(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium mt-1 css-vubbuv']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='16']"))).click();
        driver.findElement(By.xpath("//input[@id='Reviewed By']")).sendKeys("Dhanush");
        driver.findElement(By.xpath("(//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium mt-1 css-vubbuv'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='16']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Save']"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+modName+"')]"))).click();	}
	

}
