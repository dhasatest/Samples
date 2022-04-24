package test;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGProject {
	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void googleSearch() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Dhasa",Keys.ENTER);
	}
	@Test
	public void googleSearch2() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success",Keys.ENTER);
	}
	@Test
	public void googleSearch3() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success",Keys.ENTER);
	}
	@Test
	public void googleSearch4() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success",Keys.ENTER);
	}
	@Test
	public void googleSearch5() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success",Keys.ENTER);
	}
	@Test
	public void googleSearch6() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success",Keys.ENTER);
	}
	@Test
	public void googleSearch7() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success",Keys.ENTER);
	}
	@Test
	public void googleSearch8() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success1",Keys.ENTER);
	}
	@Test
	public void googleSearch9() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success2",Keys.ENTER);
		
	}
	@Test
	public void googleSearch10() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success3",Keys.ENTER);
	}
	@Test
	public void googleSearch11() {
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Success4",Keys.ENTER);
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Testing Completed Successfully");
	}

}

