package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleCheckBoxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		List<WebElement> dayschkbox = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox' ] "));
		
		
		for(int i=5; i<=dayschkbox.size();i++) {
			
			
			dayschkbox.get(i).click();
			
		}
		
	/*	for(WebElement chk:dayschkbox) {
			String day = chk.getAttribute("id");
			if (day.equals("monday") || day.equals("friday") ) {
				chk.click();
				
			}
		*/	
				
		}
		
		
	
		
		

	}

