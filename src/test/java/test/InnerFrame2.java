package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
		
		driver.switchTo().frame("iframeResult");
		
		
		//WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='demo_iframe.htm']"));
		
		driver.switchTo().frame(0);
		
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame();
	  String text = driver.findElement(By.xpath("//p[contains(text(),'An iframe is used to display a web page within a web page:']")).getText();
	  
	  System.out.println(text);
		
		
		
		
		
	}
}
