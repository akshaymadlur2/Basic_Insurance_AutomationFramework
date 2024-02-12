package resuableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectsRepo;

public class ExtentSetup extends ObjectsRepo{
	public static ExtentReports setupExtentReport() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		String Actualdate =format.format(date);
		String reportPath =  System.getProperty("user.dir")+"/Reports/ExecutionReport_"+Actualdate+".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		 extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		sparkReport.config().setDocumentTitle("Document Title");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");
		return extent;
	}

}
