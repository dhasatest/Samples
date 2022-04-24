package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DropdownGenerincMedhod {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement  dropdnele = driver.findElement(By.id("input-country"));
		
		//Select dropdn =  new Select(dropdnele);
		//dropdn.selectByVisibleText("India");
		
		//List<WebElement> dropvalues = driver.findElements(	By.id("input-country"));
		
		SelectDropdown(dropdnele,"China");
		
	  
	}
	
	
	public static void SelectDropdown(WebElement ele, String val)
	{
		
	Select drp = new Select(ele);

		
    List<WebElement> dropdownvalues = drp.getOptions();
	
	for (WebElement elem:dropdownvalues) {
	
	  if (elem.getText().equals(val)) {
		
	    elem.click();
	    break;
	  }

	  }
	
	
	}

  

}
