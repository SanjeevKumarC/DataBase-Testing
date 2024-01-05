
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class shadow  {

	public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://dat.kuza.one/dat/ke/one/#/connect");
	/*
	 * JavascriptExecutor js=(JavascriptExecutor)driver; Thread.sleep(2000);
	 * //js.executeScript(
	 * "document.getElementById('small-searchterms').value='hello';"); //
	 * Thread.sleep(2000); js.executeScript("alert('hello');");
	 */
    Thread.sleep(2000);
    Shadow s=new Shadow(driver);
    //WebElement we= driver.findElement(By.xpath("//input[@placeholder='Username']"));
    
    s.findElementByXPath("//input[@placeholder='Username']").sendKeys("kedat01");
    s.findElementByXPath("//input[@name='password']").sendKeys("9876");
    s.findElementByXPath("//ion-button[.='GO']").click();
    Thread.sleep(2000);
    String img=s.findElementByXPath("//img[@class='pl-3 mr-auto landing-kuza-logo']").getAttribute("src");
    if(img.equals("https://dat.kuza.one/dat/ke/one/assets/img/1kuza.png"))
    	System.out.println("true");
    else
    	System.out.println(img);
    Thread.sleep(2000);
   List<WebElement> heading = s.findElementsByXPath("//h1[@class='mb-0 text-dark']");
   //heading.forEach(n->System.out.println(n));
   for (WebElement we : heading) {
	if(we.getText().equals("Aggregation"))
		System.out.println("true");
}
    
	}
}
