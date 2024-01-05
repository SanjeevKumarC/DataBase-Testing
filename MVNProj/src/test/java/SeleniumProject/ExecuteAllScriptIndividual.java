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

public class ExecuteAllScriptIndividual {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	    String modName="YES MSME Mobile";
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+modName+"')]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root']"))).click();
	      Set<Entry<String, String>> key2 = getAllKey();
	      List<String>key=new ArrayList<>();
	      for (Map.Entry<String, String> entry : key2) {
			 key.add(entry.getKey());		
		}
	   //all modules
	    for (int j=0;j<key.size();j++) {
	    	Thread.sleep(1000);
	    	String subMod=key.get(j);
	        System.out.println(j+" "+key.get(j));
	     // String subMod="A009";
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+subMod+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title and contains(@class,'repo')]")));
		List<WebElement> listOfScript = driver.findElements(By.xpath("//span[@title and contains(@class,'repo')]"));
       try {
		 for (int i = 0; i <listOfScript.size() ; i++) {//listOfScript.size()
			 Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@title and contains(@class,'repo')]")));
			List<WebElement> listOf = driver.findElements(By.xpath("//span[@title and contains(@class,'repo')]"));
			System.out.println(listOf.get(i).getText());
			String text=listOf.get(i).getText();
			listOf.get(i).click();
			DumpManualTestCase(driver,wait,text,subMod);
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Completed....");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+modName+"')]"))).click();
	    }
	    
		driver.quit();
  }

	private static void DumpManualTestCase(WebDriver driver, WebDriverWait wait, String text, String modName) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='step-break']")));
		List<WebElement> steps = driver.findElements(By.xpath("//span[@id='step-break']"));
		List<String> allSteps = new ArrayList<String>();
		int ind=0;
        for (int i=0;i<steps.size();i++) {
			if(steps.get(i).getText().contains("Launch App - Step Group")) {
				ind=i;
			}	
		}
        String title="";
		for (int i=ind;i<steps.size();i++) {
			steps = driver.findElements(By.xpath("//span[@id='step-break']"));
			if(steps.get(i).getText().contains("SKIP") ||steps.get(i).getText().contains("CLOSE APP") || 
					steps.get(i).getText().contains("Verify the Popup is not displayed")|| 
					steps.get(i).getText().contains("Tap on navigate button in Expected popup")) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'SKIP and Verify') or contains(text(),'CLOSE APP') or contains(text(),'Verify the Popup') or contains(text(),'Tap on navigate button in Expected')]"))).click();
					Thread.sleep(2000);
					title=driver.findElement(By.id("Popup Title")).getAttribute("value");
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Go to step group']"))).click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='step-break']")));
					List<WebElement> steps1 = driver.findElements(By.xpath("//span[@id='step-break']"));
					//System.out.println(steps1.size());
					for (int j=0;j<steps1.size();j++) {
					  //System.out.println(j+" "+steps1.get(j).getText());
					    allSteps.add(steps1.get(j).getText());
					}
					driver.navigate().back();
					Thread.sleep(4000);	
			 }
			else
				allSteps.add(steps.get(i).getText());		 
		}
		
		ArrayList<String> temp=new ArrayList<>();
		System.out.println("..................");
		for (String ff : allSteps) {
			if(ff.contains("Get")) {
				 if(ff.contains("ScreenShot"))
					temp.add(ff.replace("Android_Check If", "Verify User"));
			}
			else if(ff.contains("Condition") || ff.contains("Wait") || ff.contains("Boolean") || ff.contains("ADB Command Runner") || ff.contains("Create session")) {}
			else 
				temp.add(ff.replace("- Step Group", "").replace("Navigate to","Tap on Skip button until the").replace("Android_", "").replace("Element","Skip").replace("Expected", title).replace("Pop up text", title+" Popup").replace("Popup TITLE text", title+ " title" ).replace("Click","Tap").replace("Check If Value Is Not Present In List", "Verify "+title+" Popup is not displayed").replace("Mob_", "").replace("Verify if", "Verify"));
						
		}    
		ArrayList<String> al1 = new ArrayList<String>();
		String statement = "User should able to";
		//String print = "should not be";
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).toLowerCase().toString().contains("not")) {
				al1.add(temp.get(i).toString().replace("is not", "should not be").replace("Verify","").replace("the", "").replace("Android_Check If","User should ").replace("User Not","User Should Not"));
			} else if(temp.get(i).toLowerCase().toString().contains("is displayed"))
				al1.add(temp.get(i).toString().replace("Verify", "").replace("is "," should be "));
			else
				al1.add(statement + " ".concat((String) temp.get(i).replace("Verify", "").replace("Mob_", "")));
		}
		Map<String, String> hm = new LinkedHashMap<>();
		for (int i = 0; i < allSteps.size(); i++) {
				hm.put(allSteps.get(i), " ");
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Manual Test Case')]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ml-auto pl-4']//button")));
		if(driver.findElement(By.xpath("//div[@class='ml-auto pl-4']//button")).getText().equals("Edit")){
			driver.findElement(By.xpath("//div[@class='ml-auto pl-4']//button")).click();
		}
		Thread.sleep(2000);
		for (int i = 3; i <temp.size(); i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Insert row below']"))).click();
		}
		driver.findElement(By.xpath("//td[3]")).sendKeys(".");
		driver.findElement(By.xpath("//td[3]")).clear();
		driver.findElement(By.xpath("//td[3]")).sendKeys(text.substring(text.indexOf(' '),text.length()).trim());
	     Set<Entry<String, String>> key2 = getAllKey();
	     Map<String,String> mp=new LinkedHashMap<>();
	    for (Map.Entry<String,String> entry :key2) {
			mp.put(entry.getKey(), entry.getValue());
		}
	   
	    if(text.contains("not")) 
		 driver.findElement(By.xpath("//td[4]")).sendKeys(mp.get(modName).replace("should be", "should not be").replace("manual", "none"));
	    else 
	    	driver.findElement(By.xpath("//td[4]")).sendKeys(mp.get(modName));
		
		  int inc=0;
			for ( int i=0;i<temp.size();i++) {
				driver.findElement(By.xpath("(//td[2])["+ ++inc +"]")).sendKeys(inc+"");
				driver.findElement(By.xpath("(//td[5])["+ inc +"]")).sendKeys("N/A");
				driver.findElement(By.xpath("(//td[6])["+ inc +"]")).sendKeys(temp.get(i).trim());
				driver.findElement(By.xpath("(//td[7])["+ inc +"]")).sendKeys(al1.get(i).trim());
			}	
		driver.findElement(By.id("Requirement Id")).sendKeys(text.substring(0,text.indexOf(' ')));
        driver.findElement(By.id("Created by")).sendKeys("Sanjeev Kumar C");
        driver.findElement(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium mt-1 css-vubbuv']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='17']"))).click();
        driver.findElement(By.xpath("//input[@id='Reviewed by']")).sendKeys("Henry Jones");
        driver.findElement(By.xpath("(//*[name()='svg' and @class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium mt-1 css-vubbuv'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='20']"))).click();
        Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Save']"))).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+modName+"')]"))).click();	
   }
	private static Set<Entry<String, String>> getAllKey() {
		Map<String,String> map=new LinkedHashMap<String,String>();
		map.put("A001","N/A");
		map.put("A002","N/A");
		map.put("A003","Device should be rooted");
		map.put("A004","Enable the wifi and change the Proxy  to manual");
		map.put("A005","N/A");
		map.put("A007","Mobile screen should be in sharing");
		map.put("A009", "VPN should be connected");
		map.put("A010", "Developer Options should be enabled");
		map.put("A011", "USB debugging should be enabled");
		map.put("A012", "Device should not be locked");
		map.put("A013", "Application should not be installed from secured source");
		map.put("A014", "Device Admin permission should be enabled");
		map.put("A015", "Wireless debugging should be enabled");
		map.put("A016", "Accessibility settings should be enabled");
		map.put("A017", "Mock location should be enabled");
		map.put("A018", "Device should be connected via USB");
		map.put("A019", "Automatic date and time should be disabled");
		map.put("A020", "Device should be connected with unsecured Wi-Fi");
		map.put("A026", "Harmful application should be installed");
		return map.entrySet();
	}

}
