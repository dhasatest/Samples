package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redbus.in");
		
		String inpDate = "25";
		String inpMonth = "Jun";
		String inpYear = "2050";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		

		while(true) {		

			String monthHeader = driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[@class='monthTitle']")).getText();
			if (monthHeader.equals(inpMonth + " " + inpYear)){
				driver.findElement(By.xpath("//tbody//tr//td[text()='"+inpDate+"']")).click();
				break;
			}

			driver.findElement(By.xpath("//td[@class='next']")).click();

		}

		//driver.close();
			
	}
}
