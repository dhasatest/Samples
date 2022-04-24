package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown_BingSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.bing.com");
		driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");
		
		List<WebElement> srchresult = driver.findElements(By.xpath("//div[@class='sa_as']/ul/li"));
		
		System.out.println(srchresult.size());
		
		for (WebElement el : srchresult) {
			
			if(el.getText().equals("selenium download")) {
				el.click();
				break;
			}
		}
		
			

	}

}
