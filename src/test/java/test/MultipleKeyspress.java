package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleKeyspress {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
			driver.get("https://text-compare.com");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("ez-video-ez-stuck-close")).click();
			
			WebElement  lfttxt = driver.findElement(By.name("text1"));
			//WebElement  rgttxt = driver.findElement(By.name("text2"));
			
	
			lfttxt.sendKeys("Dhasarathan");
			Actions act = new Actions(driver);
			act.keyDown(Keys.CONTROL);
			act.sendKeys("a");
			act.keyUp(Keys.CONTROL);
			act.perform();
			
			act.keyDown(Keys.CONTROL);
			act.sendKeys("c");
			act.keyUp(Keys.CONTROL);
			act.perform();
			
			act.sendKeys(Keys.TAB).perform();
			
			act.keyDown(Keys.CONTROL);
			act.sendKeys("v");
			act.keyUp(Keys.CONTROL);
			act.perform();
			
	
			driver.findElement(By.id("compareButton")).click();
			String text  = driver.findElement(By.xpath("//span[@class='messageForUser']")).getText();
			if (text.equals("The two texts are identical!"))
				System.out.println("Pass");
			else
				System.out.println("Fail");

				driver.close();
			
	
			
			

	}

}
