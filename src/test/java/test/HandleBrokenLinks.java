package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://deadlinkcity.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int brlink=0;

		for (WebElement lnk : links) {

			String url = lnk.getAttribute("href");

			if(url == null || url.isEmpty()) {

				System.out.println("Url is Empty");
				continue;
			}


			URL link = new URL(url);

			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();

				if(httpconn.getResponseCode()>=400) {
					System.out.println(httpconn.getResponseCode() + url + "Broken Link");
					brlink++;
				}
				else {
					System.out.println(httpconn.getResponseCode() + url + "Valid Link");
				}


			} catch (IOException e) {


			}

		}
		System.out.println("Number of broken links are :  "+ brlink);

	}

}
