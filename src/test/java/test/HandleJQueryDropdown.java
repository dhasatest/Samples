package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJQueryDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		//List<WebElement> vals =  driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']"));
		
		
		//selectvalues(driver,"choice 1");
		selectvalues(driver,"choice 1", "choice 2", "choice 2 1", "choice 6");
		//selectvalues(driver,"all");
		//driver.close();		
	
	}
public static void selectvalues(WebDriver driver , String... item ) {
	
	List<WebElement> vals =  driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
	
	if(!item[0].equalsIgnoreCase("all")) {
		
		for(WebElement el:vals) {
			
			String txt = el.getText();
			
			for(String itm: item) {
				if(txt.equals(itm)) {
					
					el.click();
					break;
				}
			}
			
		}
	}
	else {
		
		try {
		for (WebElement el:vals) {
			el.click();
		}
		}
		
		catch(Exception e) {
		}
		}
	}
		
}
	

