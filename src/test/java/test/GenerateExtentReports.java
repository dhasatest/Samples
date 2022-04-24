package test;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateExtentReports {
	
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	
	@BeforeTest
	public void startReport() {
		spark= new ExtentSparkReporter("ExtentSpark.html");
		extent = new ExtentReports();
		 extent.attachReporter(spark);
		 
		 extent.createTest("TestName").pass("Test Passed");
		 
		 extent.flush();
	}
	

}
	