package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com");

		//WebElement searchbox =  driver.findElement(By.xpath("//input[@id='small-searchterms']"));

		//searchbox.sendKeys("Dhasa", Keys.RETURN);

		//WebElement ele = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));

		//System.out.println(ele.getText());

		List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));

		//System.out.println("Number of elements capturesd" + links.size());

		for (WebElement elem : links) {

			String linktxt = elem.getText();
			
			if (linktxt.equals("Recently viewed products")) 
			{
				System.out.println(linktxt);
				elem.click();

			}   
			

		}
driver.close();
driver.quit();

	}


}
