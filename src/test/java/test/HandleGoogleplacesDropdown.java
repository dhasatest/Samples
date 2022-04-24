package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleGoogleplacesDropdown {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.twoplugs.com/newsearchserviceneed");
	driver.manage().window().maximize();
	//driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
	WebElement gdrop =  driver.findElement(By.id("autocomplete"));
	
	gdrop.clear();
	
	gdrop.sendKeys("Toronto");

   String text; int i=0;
	
	do {
	   	gdrop.sendKeys(Keys.ARROW_DOWN);		
		text = gdrop.getAttribute("value");
		if(text.equals("Toronto, OH, USA")) {
			gdrop.sendKeys(Keys.ENTER);
			i++;
			break;
		}
		Thread.sleep(3000);
	}while(!text.isEmpty());

	
	System.out.println(i + text);
	

	

	}

}
