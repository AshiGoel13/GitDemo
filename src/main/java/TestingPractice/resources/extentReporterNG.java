package TestingPractice.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {

	public static ExtentReports getObjectReport()
	{
String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Ashi Gupta");
		return extent;
		
	}
}
