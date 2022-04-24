package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDropImage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement img1 = driver.findElement(By.xpath("//h5[@class='ui-widget-header' and text()='High Tatras']/following-sibling::img"));
		WebElement trash = driver.findElement(By.id("trash"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(img1, trash).perform();;
		
		
				
			
	}

}
