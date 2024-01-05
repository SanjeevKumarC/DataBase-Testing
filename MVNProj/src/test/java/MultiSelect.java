

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.navigate().to("file:///C:/Users/ADMIN/Downloads/MultiSelect.html");
		WebElement country = d.findElement(By.id("country"));
		Select s = new Select(country);
		List<WebElement> li = s.getOptions();
//		for (WebElement we : li) {
//			System.out.println(we.getText());
//		}
		System.out.println(li.size());
		for (int i = 0; i < li.size(); i+=2) {
				s.selectByIndex(i);
		}
	}

}
