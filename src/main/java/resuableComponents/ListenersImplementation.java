package resuableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectsRepo;

public class ListenersImplementation extends ObjectsRepo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		 test =extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test case: " + result.getMethod().getMethodName()+ " is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test case: " + result.getMethod().getMethodName()+ " is Failed");
		//fetch exception
		test.log(Status.FAIL,result.getThrowable());
		//add screen shot
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		String Actualdate =format.format(date);
		String sreenshotPath =  System.getProperty("user.dir")+"/Reports/Screenshots/"+Actualdate+".jpeg";
		File dest = new File(sreenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(sreenshotPath,"Test Case Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//setup method for extent report
		extent = ExtentSetup.setupExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//close extent
		extent.flush();
	}

}
