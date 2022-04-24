package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.get("https://google.com");
		//WebElement search = driver.findElement(By.name("q"));
		//search.sendKeys("Dhasa", Keys.ENTER);
		
	/*	driver.navigate().to("https://trytestingthis.netlify.app/");
		
         List<WebElement> options =  driver.findElements(By.name("Optionwithcheck[]"));	
         
         for (WebElement element : options) {
        	 System.out.println(element.getText());
         }
         	
         driver.findElement(By.cssSelector("#fname")).sendKeys("Dhasarathan"); */
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		
	driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn)).sendKeys("Dhasarathan");;
		
         
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		
	}
}
