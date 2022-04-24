package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class DynamicWebTablewithPagenation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://demo.opencart.com/admin/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement user = driver.findElement(By.xpath("//input[@id='input-username']"));		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		user.clear();
		user.sendKeys("demo");
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()=' Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		//System.out.println(text);
		
		int TotPages  = Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		//System.out.println(TotPages);
		
		
		
		for(int p=1; p<=10; p++) {
			
			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			System.out.println("Active Page: " + activePage.getText());
			activePage.click();
			
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			//System.out.println("Number of Rows: "+rows);
			
			for(int i=1; i<=rows; i++) {
				String orderId = (driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td[2]")).getText());
				String customer = (driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td[3]")).getText());
				String status = (driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td[4]")).getText());
				String total = (driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td[5]")).getText());
				
				
				if (status.equals("Pending")) {
				System.out.println(orderId + " | " + customer +" | " + status + " | " + total);
				}
			}
			
			String pageno = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+ pageno+ "']")).click();
					
			
			
		}
		
	driver.close();
		
		
	}

}
