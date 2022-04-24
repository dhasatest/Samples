package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
        
		WebElement srcRome = driver.findElement(By.id("box6"));
		WebElement tgtItaly = driver.findElement(By.id("box106"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(srcRome,tgtItaly).perform();		
	}

}
