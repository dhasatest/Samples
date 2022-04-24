package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
	driver.findElement(By.xpath("//li[1]/button")).click();
	driver.switchTo().alert().accept();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[2]/button")).click();
	driver.switchTo().alert().dismiss();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[3]/button")).click();
	Alert popup = driver.switchTo().alert();
	System.out.println(popup.getText());
	popup.sendKeys("Dhasarathan");
	popup.accept();
	
	
	
	
	
		

	}

}
