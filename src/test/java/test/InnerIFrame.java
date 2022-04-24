package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		
		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerFrame);
		
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html 	']"));
		
		driver.switchTo().frame(innerFrame);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Dhasa");
		
		
	}

}
