package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		WebElement men1 = driver.findElement(By.xpath("//a[text()='Desktops']"));
		
		WebElement men2 = driver.findElement(By.xpath("//a[text()='Mac (1)']"));

		Actions act = new Actions(driver);
		
		act.moveToElement(men1).moveToElement(men2).click().perform();
		
	}
}
