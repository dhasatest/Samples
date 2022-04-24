package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropdown {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		String inpMonth = "Feb";
		String inpYear = "1987";
		String inpDate = "2";
		
		
		driver.findElement(By.id("dob")).click();
		
		try {
		WebElement drpmonth = driver.	findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']"));		
		Select month = new Select(drpmonth);
		month.selectByVisibleText(inpMonth);
		
		WebElement drpyear = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']"));		
		Select year = new Select(drpyear);
		year.selectByVisibleText(inpYear);
		
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td//a[text()='"+inpDate+"']")).click();
		} 
		catch (Exception e) {
			System.out.println("Eroor ...Date out of range ");
		}

		finally {
			driver.close();	
		}
		
		
		
	}

}
