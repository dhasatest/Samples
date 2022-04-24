package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver  = new ChromeDriver()
			
		
		//Create a map to store  preferences 
		//Map<String, Object> prefs = new HashMap<String, Object>();
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		//prefs.put("profile.default_content_setting_values.notifications", 1);
		

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// set ExperimentalOption - prefs 
	//	options.setExperimentalOption("prefs", prefs);
		

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		WebDriver driver = new ChromeDriver(options);
		
	

		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
		
	     driver.findElement(By.xpath("//div[@class='banner-hnw']/img")).click();	
	
	
	// Product Type
	WebElement ProdTypeDrp = driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']"));	
	List<WebElement> productType = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
	selectOptionFromDropdown(ProdTypeDrp,productType,"Accounts");

	
	WebElement Prod = driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']"));
	List<WebElement> product = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
	selectOptionFromDropdown(Prod,product,"Current Accounts");


	//driver.close();
	}

	
	public static void selectOptionFromDropdown( WebElement drpdnclk, List<WebElement> Listim, String selctn ) {		
		drpdnclk.click();
		
		for(WebElement lst:Listim) {
			if(lst.getText().equals(selctn)) {
				lst.click();
				break;
			}
		}
			
		
		
	}
}
