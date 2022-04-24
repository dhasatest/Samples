package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver  = new ChromeDriver();
		

		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		
	//	driver.findElement(By.linkText("Today's Deals")).click();
		//driver.findElement(By.partialLinkText("Today")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement lnk : links) {
			
			System.out.println(lnk.getText());
			System.out.println(lnk.getAttribute("href"));
			
		}
		System.out.println(links.size());
		
	}

}
