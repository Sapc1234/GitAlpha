package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoTest {
	ExtentReports extent;
	
	
	@BeforeTest
	public void config()
	
	{
		//ExtentReports,ExtentSparkReporter   ->these 2 are very imp classes for generate the reports
		
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Rahulshetty");
	}
	
	@Test
	public void initialDemo()
	
	{
		ExtentTest test = extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver","C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\rahulshettyacademy.com");
		driver.getTitle();
		driver.getCurrentUrl();
		driver.getPageSource();
		test.fail("Result donot match");
		extent.flush();
	}

}
