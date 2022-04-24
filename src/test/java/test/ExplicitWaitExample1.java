package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExplicitWaitExample1 {


	public static  WebElement waitForElementVisible(By locator, WebDriver driver, int durationInSec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSec));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement el = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium']")));
		//el.sendKeys("Selenium");

		waitForElementVisible(By.name("q"),driver, 10).sendKeys("Selenium",Keys.ENTER);
		waitForElementVisible(By.xpath("//h3[text()='Selenium']"),driver, 10).click();	

		driver.close();
	}



}
