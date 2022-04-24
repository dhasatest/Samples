package test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class NopCommerceTest {
	
	public static void main(String[] args) {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(".//MyTestReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest test = extent.createTest("TC001_Login");
		test.pass("Enter user name");
		test.pass("Enter passord", MediaEntityBuilder.createScreenCaptureFromPath(".//image1.png").build()).addScreenCaptureFromPath(".//image1.png");
		test.pass("Clink Login");
		test.assignAuthor("Rathin");
		test.addScreenCaptureFromPath(".//image1.png");
		test.assignCategory("NewFunctionaity");
		
		ExtentTest test2 = extent.createTest("TC002_Login2");
		test2.pass("Enter user name");
		test2.fail("Enter passord", MediaEntityBuilder
				.createScreenCaptureFromPath(".//image1.png")
				.build());
		test2.pass("Clink Login");
		test2.assignCategory("Regression");
		test2.assignAuthor("Dhasa");
		extent.flush();
				
		
	}
	
	

}
