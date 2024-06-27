package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\Report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation result");
		reporter.config().setDocumentTitle("ajith report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "ajith");
		return extent;
	}

}
