package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextvsGetattributevalue {
	
	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement Searchtxtbox = driver.findElement(By.id("Email"));
		
		
		System.out.println(" The default value of textbox " + Searchtxtbox.getAttribute("value"));
		System.out.println(" The default value of GET TEXT  " + Searchtxtbox.getText());
		

		
		Searchtxtbox.clear();
		
		Searchtxtbox.sendKeys("dhasaa@ymail.com");
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		
		System.out.println("Button text "+button.getText());
		System.out.println("Button Attribute type "+button.getAttribute("Type"));
		
		String title = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
		System.out.println("Page Title is "+title);
		
		

		
	}

}
