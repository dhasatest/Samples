package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropdowndatasort {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();;
		
		WebElement drpElement = driver.findElement(By.name("category_id"));
		
		Select drpSelect = new Select(drpElement);
		
		List<WebElement> options = drpSelect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for(WebElement option : options) {
			if(option.getText() != "All") {
			originalList.add(option.getText());
			tempList.add(option.getText());
			}
		}
		
		System.out.println("Original List "+originalList );
		
		Collections.sort(tempList);
		
		System.out.println("Temp List "+tempList );
		
		if(originalList.equals(tempList)) {
			System.out.println("List Sorted");
		}
		else
		{
			System.out.println("Unsorted");
		}
		
		driver.close();
		
		
		
		
		
		
		//driver.findElement(By.xpath("//div[@class='box-input clearfix']//div[@class='jq-selectbox__trigger-arrow']")).click();
		
		//List<WebElement> ServType = driver.findElements(By.xpath("//div[@class='jq-selectbox__dropdown']/ul/li"));
		
		//List<WebElement> temp = ServType;
		
		
		
				
	}

}
