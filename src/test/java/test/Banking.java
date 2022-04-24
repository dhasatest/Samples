package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Banking {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/V1/index.php");
		
		driver.findElement(By.name("uid")).sendKeys("mngr399908");
		driver.findElement(By.name("password")).sendKeys("ajyhajA");
		driver.findElement(By.name("btnLogin")).click();

	}

}
