package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		driver.switchTo().frame("packageListFrame");
		
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium.chrome']")).click();
		
		driver.switchTo().defaultContent();
        driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.linkText("AddHasCasting")).click();
		

		driver.switchTo().defaultContent();
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();
        
        
      

	}

}
