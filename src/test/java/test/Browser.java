package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));																																																												 

		
		//driver.get("https://google.com");
		//String originalWindow = driver.getWindowHandle();
		
		//driver.navigate().to("https://automationstepbystep.com");
/*
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.navigate().back();
		String originalWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();

	
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().window(originalWindow);
	
	*/
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().setSize(new Dimension(800,600));
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Alert")).click();
		driver.switchTo().defaultContent();
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("./image1.png"));
	
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();


	}  

}
