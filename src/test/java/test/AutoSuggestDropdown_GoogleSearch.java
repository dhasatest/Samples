package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown_GoogleSearch{

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(3000);
		
		List<WebElement> srchresult = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]/span	"));
		
		System.out.println(srchresult.size());
		
		for (WebElement el : srchresult) {
			System.out.println(el.getText());
			if(el.getText().contains("download")) {
				el.click();
				
				break;
			}
  		
			

	}

}
}
