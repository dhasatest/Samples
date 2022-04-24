package test;

import java.io.File;
	
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".//Screenshot//homepage.png");
		FileUtils.copyFile(src, tgt);
		
			
		//TakesScreenshot ts = (TakesScreenshot)driver;
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src1 = section.getScreenshotAs(OutputType.FILE);
		File tgt1 = new File(".//Screenshot//product.png");
		FileUtils.copyFile(src1, tgt1);
		
		//System.out.println(Keys.chord(Keys.CONTROL, Keys.ENTER));
		
		
		driver.close();
		
	}
}
