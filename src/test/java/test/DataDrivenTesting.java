package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTesting {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}	

	@Test(dataProvider="login")
	public void loginTest(String user, String pass, String val) {
		driver.get("https://www.tnebnet.org/awp/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());

		WebElement username = driver.findElement(By.id("userName"));
		username.clear();
		username.sendKeys(user);

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(pass);

		driver.findElement(By.name("submit")).click();
		System.out.println(driver.getTitle());

		if(val.equals("Valid")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("paymentDetail?execution"));
			driver.findElement(By.linkText("Logout"));

		}else if(val.equals("Invalid")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("login_error"));
		}


		//https://www.tnebnet.org/awp/paymentDetail?execution=e1s1
		//https://www.tnebnet.org/awp/login?login_error=1
	}

	@DataProvider(name="login")
	public String[][] getData() throws IOException{

		String path = ".//Book.xlsx";

		XLUtility xl = new XLUtility(path);
		int rows = xl.getRowCount("Sheet1");
		int cols = xl.getColumnCount("Sheet1", 0);
		String credentials[][] = new String[rows][cols];

		for(int r=1; r<=rows; r++) {

			for(int c=0; c<cols; c++) {
				credentials[r-1][c] = xl.getCellData("Sheet1", r, c);


			}
			xl.setCellData("Sheet1", r, cols, "Tested");
			xl.setCellColorRed("Sheet1", r, cols);
		}
		return credentials;
	}
	
		/*
	FileInputStream inputstream = new FileInputStream(".//Book.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheetAt(0);

	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	String credentials[][]= new String[rows][cols];

	for(int r=1; r<=rows; r++) {
		XSSFRow row = sheet.getRow(r);

		for(int c=0; c<cols; c++) {
		XSSFCell cell = row.getCell(c);		
		credentials[r-1][c]=cell.getStringCellValue();
		}

	}*/

	

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
