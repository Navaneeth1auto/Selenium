package Automation.Selenium;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners extends Base implements ITestListener{

	public void onFinish(ITestContext result) {
		System.out.println("Test is Finised:"+ result.getName());
		
	}

	public void onStart(ITestContext result) {
		System.out.println("Test is Started:"+ result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test is onTestFailedButWithinSuccessPercentage:"+ result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		/*try {
			System.out.println("in try block of onTestFailure");
			sendEmail();
		} catch (EmailException e) {
			System.out.println("in catch block of onTestFailure");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Test is Failured:"+ result.getName());
		try {
			takeScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped:"+ result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		
		System.out.println("Test is Stared:"+ result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is succesful:"+ result.getName());
		try {
			takeScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
